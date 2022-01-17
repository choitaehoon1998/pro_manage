package com.tae.hoon.speciallist.goods.service;

import com.tae.hoon.speciallist.Enum.useStatus.UseStatus;
import com.tae.hoon.speciallist.goods.domain.Goods;
import com.tae.hoon.speciallist.goods.repository.GoodsRepository;
import com.tae.hoon.speciallist.goodsOp.domain.GoodsOp;
import com.tae.hoon.speciallist.goodsOp.repository.GoodsOpRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsOpRepository goodsOpRepository;

    public GoodsService(GoodsRepository goodsRepository, GoodsOpRepository goodsOpRepository) {
        this.goodsRepository = goodsRepository;
        this.goodsOpRepository = goodsOpRepository;
    }

    private boolean isExist(Long indexNo) {
        if (indexNo != null && goodsRepository.existsById(indexNo)) {
            return true;
        }
        return false;
    }

    private boolean isUse(UseStatus useStatus) {
        if (useStatus != null && useStatus.getValue().equals(UseStatus.USE.getValue())) {
            return true;
        }
        return false;
    }

    public List<Goods> findAllGoods(HashMap<String, Object> hashMap) {
        List<Goods> GoodsList = goodsRepository.findAllUsingQueryDsl(hashMap);
        return GoodsList;
    }

    public void saveOrUpdateGoods(Goods goods) {
        if (isUse(goods.getUseStatus())) {
            for (GoodsOp goodsOp : goods.getGoodsOpList()) {
                goodsOp.setGoods(goods);
            }
        } else {
            goods.setGoodsOpList(new ArrayList<>());
        }
        if (goods.getRegidate() == null) {
            goods.setRegidate(LocalDateTime.now());
        }
        goodsRepository.save(goods);
    }

    public void deleteGoods(Goods goods) {
        if (isExist(goods.getIndexNo())) {
            goodsRepository.deleteById(goods.getIndexNo());
        }
    }

    public void updateGoods(Goods goods) {
        if (isExist(goods.getIndexNo())) {
            saveOrUpdateGoods(goods);
        }
    }
}
