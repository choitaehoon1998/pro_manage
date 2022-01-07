package com.tae.hoon.speciallist.orderItem.domain;

import com.tae.hoon.speciallist.item.domain.Item;
import com.tae.hoon.speciallist.order.domain.Order;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @Column(name = "ORDER_ITEM_ID")
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;

    @Column(name = "ORDER_PRICE")
    private int orderPrice;

    @Column(name = "COUNT")
    private int count;
}
