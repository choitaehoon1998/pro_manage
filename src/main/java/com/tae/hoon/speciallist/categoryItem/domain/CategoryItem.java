package com.tae.hoon.speciallist.categoryItem.domain;

import com.tae.hoon.speciallist.category.domain.Category;
import com.tae.hoon.speciallist.item.domain.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "CATEGORY_ITEM")
public class CategoryItem {
    @Id
    @Column(name = "CATEORY_ITEM_ID")
    private Long categoryItemId;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
