package com.tae.hoon.speciallist.goods.repository;

import com.tae.hoon.speciallist.goods.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long>, GoodsQueryRepository {
}
