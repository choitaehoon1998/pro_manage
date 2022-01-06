package com.tae.hoon.speciallist.user.domain;

import com.tae.hoon.speciallist.Enum.gender.Gender;
import com.tae.hoon.speciallist.Enum.gender.GenderConvertor;
import com.tae.hoon.speciallist.order.domain.Order;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "GENDER")
    @Convert(converter = GenderConvertor.class)
    private Gender gender;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @OneToMany
    private List<Order> orders = new ArrayList<>();

}
