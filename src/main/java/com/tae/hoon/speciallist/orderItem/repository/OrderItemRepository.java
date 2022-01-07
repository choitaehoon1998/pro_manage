package com.tae.hoon.speciallist.orderItem.repository;

import com.tae.hoon.speciallist.orderItem.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, OrderItemQueryRepository {
}
