package com.tae.hoon.speciallist.orderItem.repository;

import com.tae.hoon.speciallist.orderItem.domain.OrderItem;
import com.tae.hoon.speciallist.orderItem.dto.OrderItemDto;

import java.util.Optional;

public interface OrderItemQueryRepository {

    Optional<OrderItem> findByIdTest(Long Id);

    Optional<OrderItemDto> findByIdTest2(Long Id);
}
