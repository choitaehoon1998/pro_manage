package com.tae.hoon.speciallist.category.controller;

import com.tae.hoon.speciallist.category.dto.CategoryDto;
import com.tae.hoon.speciallist.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createCategorys(@RequestBody CategoryDto categoryRequestDto) {
        Long categorySavedSeq = categoryService.saveNew(categoryRequestDto);
        return ResponseEntity.ok(categorySavedSeq);
    }

    @GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDto>> getCategorys() {
        List<CategoryDto> categoryResponseDtoList = categoryService.findAll();
        return ResponseEntity.ok(categoryResponseDtoList);

    }

    @PutMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDto>> putMappingCategorys(@RequestBody List<CategoryDto> categoryDtoList) {
        List<CategoryDto> unsavedList = categoryService.saveByList(categoryDtoList);
        return ResponseEntity.ok(unsavedList);
    }

    @DeleteMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCategorys() {
        categoryService.deleteAllCategorys();
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/cateogry/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postCategory() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @GetMapping(value = "/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> getByCategoryId(@PathVariable("categoryId") Long id) {
        CategoryDto categoryDto = categoryService.getByParam(id);
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping(value = "/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCategory(@PathVariable("categoryId") Long id,
                                               @RequestBody CategoryDto categoryDto) {
        categoryService.updateOrSaveCategory(categoryDto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value= "/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
