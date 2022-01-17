package com.tae.hoon.speciallist.goods.repository;

import com.tae.hoon.speciallist.goods.domain.Goods;

import java.util.HashMap;
import java.util.List;

public interface GoodsQueryRepository {
    List<Goods> findAllUsingQueryDsl(HashMap<String, Object> hashMap);
}
