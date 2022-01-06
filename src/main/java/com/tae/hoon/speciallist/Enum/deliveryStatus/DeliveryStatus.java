package com.tae.hoon.speciallist.Enum.deliveryStatus;

import com.tae.hoon.speciallist.Enum.CodeValue;

public enum DeliveryStatus implements CodeValue {

    START("S", "배송시작"),
    END("E", "배송완료");

    private String code;
    private String value;

    DeliveryStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getValue() {
        return value;
    }
}
