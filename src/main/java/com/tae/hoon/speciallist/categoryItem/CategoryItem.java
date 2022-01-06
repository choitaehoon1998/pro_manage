package com.tae.hoon.speciallist.categoryItem;

import com.tae.hoon.speciallist.category.Category;
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
    @Column(name = "ID")
    private String id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Category category;
}
