package com.tae.hoon.speciallist.order.domain;

import com.tae.hoon.speciallist.Enum.orderStatus.OrderStatus;
import com.tae.hoon.speciallist.Enum.orderStatus.OrderStatusConvertor;
import com.tae.hoon.speciallist.delivery.domain.Delivery;
import com.tae.hoon.speciallist.orderItem.domain.OrderItem;
import com.tae.hoon.speciallist.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "ORDER")
public class Order {
    @Id
    @Column(name = "ID")
    private String id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne
    private Delivery delivery;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @Column(name = "ORDER_STATUS")
    @Convert(converter = OrderStatusConvertor.class)
    private OrderStatus orderStatus;
}
