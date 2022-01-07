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
@Table(name = "ORDER1")
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "orderItemId")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @Column(name = "ORDER_STATUS")
    @Convert(converter = OrderStatusConvertor.class)
    private OrderStatus orderStatus;
}
