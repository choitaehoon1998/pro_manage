package com.tae.hoon.speciallist.category.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tae.hoon.speciallist.category.dto.CategoryDto;
import com.tae.hoon.speciallist.categoryItem.domain.CategoryItem;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "categoryItemId")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    public static Category requestDtoToEntity(CategoryDto requestDto) {
        return Category.builder().categoryId(requestDto.getCategoryId()).name(requestDto.getName()).build();
    }
}
