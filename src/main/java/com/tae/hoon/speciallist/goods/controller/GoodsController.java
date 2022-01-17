package com.tae.hoon.speciallist.goods.controller;

import com.tae.hoon.speciallist.Enum.useStatus.UseStatus;
import com.tae.hoon.speciallist.goods.domain.Goods;
import com.tae.hoon.speciallist.goods.service.GoodsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping(value = "goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Goods>> getAllGoods(@RequestParam(required = false) String gname,
                                                   @RequestParam(required = false) Long indexNo,
                                                   @RequestParam(required = false) Long account,
                                                   @RequestParam(required = false) UseStatus useStatus) {
        List<Goods> GoodsList = goodsService.findAllGoods(new HashMap<String, Object>() {{
            put("gname", gname);
            put("indexNo", indexNo);
            put("account", account);
            put("useop", useStatus);
        }});
        return ok(GoodsList);
    }

    @PostMapping(value = "goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postGoods(@RequestBody Goods goods) {
        goodsService.saveOrUpdateGoods(goods);
        return ok(null);
    }

    @PutMapping(value = "goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> putGoods(@RequestBody Goods goods) {

        goodsService.updateGoods(goods);
        return ok(null);
    }

    @DeleteMapping(value = "goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteGoods(@RequestBody Goods goods) {
        goodsService.deleteGoods(goods);
        return ok(null);
    }

}
