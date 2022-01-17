package com.tae.hoon.speciallist.goods.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tae.hoon.speciallist.Enum.useStatus.UseStatus;
import com.tae.hoon.speciallist.goods.domain.Goods;

import static com.tae.hoon.speciallist.goods.domain.QGoods.goods;
import static com.tae.hoon.speciallist.goodsOp.domain.QGoodsOp.goodsOp;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;


@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsQueryRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Goods> findAllUsingQueryDsl(HashMap<String, Object> hashMap) {

        return queryFactory.selectFrom(goods)
                .where(eqIndexNo((Long) hashMap.get("indexNo")),
                        eqGName((String) hashMap.get("gname")),
                        eqAccount((Long) hashMap.get("account")),
                        eqUseOp((UseStatus) hashMap.get("useop")))
                .leftJoin(goods.goodsOpList, goodsOp).fetchJoin().fetch();
    }

    private BooleanExpression eqIndexNo(Long indexNo) {
        if (indexNo == null) {
            return null;
        }
        return goods.indexNo.eq(indexNo);
    }

    private BooleanExpression eqGName(String gname) {
        if (StringUtils.hasText(gname)) {
            return goods.gName.contains(gname);
        }
        return null;
    }

    private BooleanExpression eqAccount(Long account) {
        if (account == null) {
            return null;
        }
        return goods.account.eq(account);
    }

    private BooleanExpression eqUseOp(UseStatus useStatus) {
        if (useStatus == null) {
            return null;
        }
        if (useStatus.getValue().equals(UseStatus.USE.getValue())) {
            return goods.useStatus.eq(UseStatus.USE);
        }
        if (useStatus.getValue().equals(UseStatus.UNUSED.getValue())) {
            return goods.useStatus.eq(UseStatus.UNUSED);
        }
        return null;
    }

}
