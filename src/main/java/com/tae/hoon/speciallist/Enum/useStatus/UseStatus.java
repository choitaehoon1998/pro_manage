package com.tae.hoon.speciallist.Enum.useStatus;

import com.tae.hoon.speciallist.Enum.CodeValue;

public enum UseStatus implements CodeValue {
    USE("Y", "사용"),
    UNUSED("N", "미사용");

    private String code;
    private String value;

    UseStatus(String code, String value) {
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
