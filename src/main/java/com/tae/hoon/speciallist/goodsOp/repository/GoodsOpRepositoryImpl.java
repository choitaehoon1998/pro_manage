package com.tae.hoon.speciallist.goodsOp.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tae.hoon.speciallist.goodsOp.domain.GoodsOp;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

import static com.tae.hoon.speciallist.goodsOp.domain.QGoodsOp.goodsOp;

@RequiredArgsConstructor
public class GoodsOpRepositoryImpl implements GoodsOpQueryRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<GoodsOp> findAllUsingQueryDsl(HashMap<String, Object> hashMap) {
        return queryFactory.selectFrom(goodsOp)
                .where(eqIndexNo((Long) hashMap.get("indexNo")),
                        eqgoodsIdx((Long) hashMap.get("goodsIdx")),
                        eqopname((String) hashMap.get("opname")),
                        eqOpaccount((Long) hashMap.get(("opaccount")))).fetch();
    }

    private BooleanExpression eqIndexNo(Long indexNo) {
        if (indexNo == null) {
            return null;
        }
        return goodsOp.indexNo.eq(indexNo);
    }

    private BooleanExpression eqgoodsIdx(Long goodsIdx) {
        if (goodsIdx == null) {
            return null;
        }
        return goodsOp.Goods.indexNo.eq(goodsIdx);
    }

    private BooleanExpression eqopname(String opname) {
        if (StringUtils.hasText(opname)) {
            return goodsOp.opname.contains(opname);
        }
        return null;
    }

    private BooleanExpression eqOpaccount(Long opaccount) {
        if (opaccount == null) {
            return null;
        }
        return goodsOp.opaccount.eq(opaccount);
    }
}
