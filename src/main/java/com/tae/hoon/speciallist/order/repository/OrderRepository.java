package com.tae.hoon.speciallist.order.repository;

import com.tae.hoon.speciallist.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderQueryRepository {
}
