package com.tae.hoon.speciallist.goodsOp.service;

import com.tae.hoon.speciallist.goods.repository.GoodsRepository;
import com.tae.hoon.speciallist.goodsOp.domain.GoodsOp;
import com.tae.hoon.speciallist.goodsOp.repository.GoodsOpRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsOpService {

    private final GoodsRepository goodsRepository;
    private final GoodsOpRepository goodsOpRepository;

    public GoodsOpService(GoodsRepository goodsRepository, GoodsOpRepository goodsOpRepository) {
        this.goodsRepository = goodsRepository;
        this.goodsOpRepository = goodsOpRepository;
    }

    private boolean isExist(Long indexNo) {
        if (indexNo != null && goodsOpRepository.existsById(indexNo)) {
            return true;
        }
        return false;
    }

    public List<GoodsOp> findAllGoodsOp(HashMap<String, Object> hashMap) {
        List<GoodsOp> goodsOpList = goodsOpRepository.findAllUsingQueryDsl(hashMap);
        return goodsOpList;
    }

    public void saveOrUpdateGoodOps(GoodsOp goodsOp) {
        goodsOpRepository.save(goodsOp);
    }

    public void updateGoodOps(GoodsOp goodsOp) {
        if (isExist(goodsOp.getIndexNo())) {
            goodsOpRepository.save(goodsOp);
        }
    }

    public void deleteGoodOps(GoodsOp goodsOp) {

        if (isExist(goodsOp.getIndexNo())) {
            goodsOpRepository.deleteById(goodsOp.getIndexNo());
        }
    }
}
