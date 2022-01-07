package com.tae.hoon.speciallist.orderItem.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tae.hoon.speciallist.item.domain.QItem;
import com.tae.hoon.speciallist.order.domain.QOrder;
import com.tae.hoon.speciallist.orderItem.domain.OrderItem;
import com.tae.hoon.speciallist.orderItem.domain.QOrderItem;
import com.tae.hoon.speciallist.orderItem.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemQueryRepository {

    private final JPAQueryFactory queryFactory;


    @Override
    public Optional<OrderItem> findByIdTest(Long Id) {
        QOrder order = QOrder.order;
        QItem item = QItem.item;
        QOrderItem orderItem = QOrderItem.orderItem;
        return Optional.ofNullable(queryFactory
                .selectFrom(orderItem)
                .where(orderItem
                        .orderItemId
                        .eq(Id))
                .leftJoin(orderItem.item, item).fetchJoin()
                .leftJoin(orderItem.order, order).fetchJoin()
                .fetchOne());
    }

    @Override
    public Optional<OrderItemDto> findByIdTest2(Long id) {

        QOrder order = QOrder.order;
        QItem item = QItem.item;
        QOrderItem orderItem = QOrderItem.orderItem;

        return Optional.ofNullable(queryFactory.select(
                Projections.fields(OrderItemDto.class,
                        Expressions.asNumber(id).as("orderItemId"),
                        orderItem.orderPrice.as("orderPrice"),
                        orderItem.count.as("count"),
                        item.itemId.as("itemId"),
                        item.name.as("itemName"),
                        item.price.as("price"),
                        item.stockQuantity.as("stockQuantity")))
                .from(orderItem)
                .where(orderItem
                        .orderItemId
                        .eq(id))
                .leftJoin(orderItem.item, item)
                .leftJoin(orderItem.order, order)
                .fetchOne());
    }
}
