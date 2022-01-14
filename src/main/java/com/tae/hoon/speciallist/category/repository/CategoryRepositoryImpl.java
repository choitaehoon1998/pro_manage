package com.tae.hoon.speciallist.category.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tae.hoon.speciallist.category.domain.QCategory;
import com.tae.hoon.speciallist.category.dto.CategoryDto;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryQueryRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<CategoryDto> findAllUsingQueryDsl() {
        QCategory category = QCategory.category;
        return queryFactory.select(
                        Projections.fields(CategoryDto.class,
                                category.categoryId.as("categoryId"),
                                category.name.as("name")))
                .from(category)
                .fetch();
    }

    @Override
    public Optional<CategoryDto> findByParamUsingQueryDsl(Long id) {
        QCategory category = QCategory.category;
        return Optional.ofNullable(
                queryFactory.select(
                                Projections.fields(CategoryDto.class,
                                        Expressions.asNumber(id).as("categoryId"),
                                        category.name.as("name")))
                        .where(category.categoryId.eq(id))
                        .from(category)
                        .fetchOne(
                        ));
    }
}
