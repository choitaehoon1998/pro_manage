package com.tae.hoon.speciallist.category.repository;

import com.tae.hoon.speciallist.category.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryRepository {
    List<CategoryDto> findAllUsingQueryDsl();

    Optional<CategoryDto> findByParamUsingQueryDsl(Long id);
}
