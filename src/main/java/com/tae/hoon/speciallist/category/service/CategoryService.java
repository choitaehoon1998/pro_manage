package com.tae.hoon.speciallist.category.service;

import com.tae.hoon.speciallist.category.domain.Category;
import com.tae.hoon.speciallist.category.dto.CategoryDto;
import com.tae.hoon.speciallist.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private boolean isCategoryDuplicated(Long categorySeq) {
        Optional<Category> optionalCategory = categoryRepository.findById(categorySeq);
        if (optionalCategory.isPresent()) {
            return true;
        }
        return false;
    }

    private boolean isIdAndDtoIdSame(CategoryDto categoryDto, Long id) {
        if (categoryDto.getCategoryId() == id) {
            return true;
        }
        return false;
    }

    public Long saveNew(CategoryDto categoryRequestDto) {
        if (isCategoryDuplicated(categoryRequestDto.getCategoryId())) {
            return 0L;
        } else {
            Category category = categoryRepository.save(Category.requestDtoToEntity(categoryRequestDto));
            return category.getCategoryId();
        }
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAllUsingQueryDsl();
    }

    public List<CategoryDto> saveByList(List<CategoryDto> categoryDtoList) {
        List<CategoryDto> unsavedCategoryDto = new ArrayList<>();
        for (CategoryDto categoryDto : categoryDtoList) {
            if (isCategoryDuplicated(categoryDto.getCategoryId())) {
                unsavedCategoryDto.add(categoryDto);
            } else {
                categoryRepository.save(Category.requestDtoToEntity(categoryDto));
            }
        }
        return unsavedCategoryDto;
    }

    public void deleteAllCategorys() {
        categoryRepository.deleteAll();
    }

    public CategoryDto getByParam(Long id) {
        Optional<CategoryDto> optionalCategoryDto = categoryRepository.findByParamUsingQueryDsl(id);
        // ControllerSupport 참고
        return optionalCategoryDto.orElseThrow(NoSuchElementException::new);
    }

    public void updateOrSaveCategory(CategoryDto categoryDto, Long id) {
        if (isIdAndDtoIdSame(categoryDto, id)) {
            categoryRepository.save(Category.requestDtoToEntity(categoryDto));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteCategory(Long id) {
        if (isCategoryDuplicated(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }

    }

}
