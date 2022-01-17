package com.tae.hoon.speciallist.goodsOp.repository;

import com.tae.hoon.speciallist.goodsOp.domain.GoodsOp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsOpRepository extends JpaRepository<GoodsOp, Long>, GoodsOpQueryRepository {
}
