package com.tae.hoon.speciallist.category.domain;

import com.tae.hoon.speciallist.categoryItem.domain.CategoryItem;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy= "categoryItemId")
    private List<CategoryItem> categoryItemList = new ArrayList<>();
}
