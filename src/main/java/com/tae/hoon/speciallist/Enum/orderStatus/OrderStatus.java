package com.tae.hoon.speciallist.Enum.orderStatus;

import com.tae.hoon.speciallist.Enum.CodeValue;

public enum OrderStatus implements CodeValue {
    START("S", "결제시작"),
    END("E", "결제완료");

    private String code;
    private String value;

    OrderStatus(String code, String value) {
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
