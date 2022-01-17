package com.tae.hoon.speciallist.goodsOp.controller;

import com.tae.hoon.speciallist.Enum.useStatus.UseStatus;
import com.tae.hoon.speciallist.goods.domain.Goods;
import com.tae.hoon.speciallist.goodsOp.domain.GoodsOp;
import com.tae.hoon.speciallist.goodsOp.service.GoodsOpService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class GoodsOpController {
    private final GoodsOpService goodsOpService;

    public GoodsOpController(GoodsOpService goodsOpService) {
        this.goodsOpService = goodsOpService;
    }

    @GetMapping(value = "goodsOp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GoodsOp>> getAllGoodsOp(@RequestParam(required = false) Long indexNo,
                                                       @RequestParam(required = false) Long goodsIdx,
                                                       @RequestParam(required = false) String opname,
                                                       @RequestParam(required = false) Long opaccount) {
        List<GoodsOp> goodsOpList = goodsOpService.findAllGoodsOp(new HashMap<String, Object>() {{
            put("indexNo", indexNo);
            put("goodsIdx", goodsIdx);
            put("opname", opname);
            put("opaccount", opaccount);
        }});
        return ok(goodsOpList);
    }


    @PostMapping(value = "goodsOp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postGoods(@RequestBody GoodsOp goodsOp) {
        goodsOpService.saveOrUpdateGoodOps(goodsOp);
        return ok(null);
    }

    @PutMapping(value = "goodsOp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> putGoods(@RequestBody GoodsOp goodsOp) {
        goodsOpService.updateGoodOps(goodsOp);
        return ok(null);
    }

    @DeleteMapping(value = "goodsOp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteGoodsOps(@RequestBody GoodsOp goodsOp) {
        goodsOpService.deleteGoodOps(goodsOp);
        return ok(null);
    }
}
