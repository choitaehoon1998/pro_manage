package com.tae.hoon.speciallist.category.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tae.hoon.speciallist.category.dto.CategoryDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "categoryId")
@Getter
@Builder
@Table(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "NAME")
    private String name;

    public static Category requestDtoToEntity(CategoryDto requestDto) {
        return Category.builder().categoryId(requestDto.getCategoryId()).name(requestDto.getName()).build();
    }
}
