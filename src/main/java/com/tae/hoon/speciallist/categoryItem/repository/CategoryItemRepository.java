package com.tae.hoon.speciallist.categoryItem.repository;

import com.tae.hoon.speciallist.categoryItem.domain.CategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryItemRepository extends JpaRepository<CategoryItem, Long>, CategoryItemQueryRepository {
}
