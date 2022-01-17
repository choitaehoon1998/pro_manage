package com.tae.hoon.speciallist.goods.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tae.hoon.speciallist.Enum.useStatus.UseStatus;
import com.tae.hoon.speciallist.Enum.useStatus.UseStatusConvertor;
import com.tae.hoon.speciallist.goodsOp.domain.GoodsOp;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
@Setter
@Table(name = "mes_goods")
public class Goods {
    @Id
    @Column(name = "index_no")
    private Long indexNo;

    @Column(name = "gname")
    private String gName;

    @Column(name = "account")
    private Long account;

    @Column(name = "useop")
    @Convert(converter = UseStatusConvertor.class)
    private UseStatus useStatus;

    @Column(name = "regidate")
    private LocalDateTime regidate;

    @OneToMany(mappedBy = "Goods", cascade = CascadeType.ALL)
    private List<GoodsOp> goodsOpList = new ArrayList<>();

}
