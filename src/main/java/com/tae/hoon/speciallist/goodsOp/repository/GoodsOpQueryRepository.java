package com.tae.hoon.speciallist.goodsOp.repository;

import com.tae.hoon.speciallist.goodsOp.domain.GoodsOp;

import java.util.HashMap;
import java.util.List;

public interface GoodsOpQueryRepository {
    List<GoodsOp> findAllUsingQueryDsl(HashMap<String, Object> hashMap);
}
