package com.tae.hoon.speciallist.orderItem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    Long orderItemId;
    Integer orderPrice;
    Integer count;
    Long itemId;
    String itemName;
    Integer price;
    Integer stockQuantity;
}
