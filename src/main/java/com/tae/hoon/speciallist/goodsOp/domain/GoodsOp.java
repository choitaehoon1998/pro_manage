package com.tae.hoon.speciallist.goodsOp.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tae.hoon.speciallist.goods.domain.Goods;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
@Setter
@Table(name = "mes_goods_op")
public class GoodsOp {

    @Id
    @Column(name = "index_no")
    private Long indexNo;

    @ManyToOne
    @JoinColumn(name = "goods_idx")
    @JsonIgnore
    private Goods Goods;

    @Column(name = "opname")
    private String opname;

    @Column(name = "opaccount")
    private Long opaccount;

}
