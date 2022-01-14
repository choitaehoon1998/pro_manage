package com.tae.hoon.speciallist.item.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "ITEM")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "itemId")
public class Item {
    @Id
    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "STOCK_QUANTITY")
    private Integer stockQuantity;

    @OneToMany(mappedBy = "categoryItemId")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

}
