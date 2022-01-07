package com.tae.hoon.speciallist.delivery.repository;

import com.tae.hoon.speciallist.delivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>, DeliveryQueryRepository {
}
