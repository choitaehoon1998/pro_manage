package com.tae.hoon.speciallist.category.repository;

import com.tae.hoon.speciallist.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryQueryRepository {
}
