package com.tae.hoon.speciallist.categoryItem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tae.hoon.speciallist.category.domain.Category;
import com.tae.hoon.speciallist.item.domain.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "categoryItemId")
@Getter
@Builder
@Table(name = "CATEGORY_ITEM", uniqueConstraints = {@UniqueConstraint(columnNames = {"ITEM_ID", "CATEGORY_ID"})})
public class CategoryItem {
    @Id
    @Column(name = "CATEGORY_ITEM_ID")
    private Long categoryItemId;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
