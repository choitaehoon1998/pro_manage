package com.tae.hoon.speciallist.item.repository;

import com.tae.hoon.speciallist.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemQueryRepository {
}
