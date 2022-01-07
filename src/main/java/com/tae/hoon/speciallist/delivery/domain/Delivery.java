package com.tae.hoon.speciallist.delivery.domain;

import com.tae.hoon.speciallist.Enum.deliveryStatus.DeliveryStatus;
import com.tae.hoon.speciallist.Enum.deliveryStatus.DeliveryStatusConvertor;
import com.tae.hoon.speciallist.order.domain.Order;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    @Column(name = "DELIVERY_ID")
    private Long deliveryId;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @Column(name = "DELIVERY_STATUS")
    @Convert(converter = DeliveryStatusConvertor.class)
    private DeliveryStatus deliveryStatus;

}
