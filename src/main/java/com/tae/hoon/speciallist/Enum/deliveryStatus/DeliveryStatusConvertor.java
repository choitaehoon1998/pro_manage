package com.tae.hoon.speciallist.Enum.deliveryStatus;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class DeliveryStatusConvertor implements AttributeConverter<DeliveryStatus, String> {
    @Override
    public String convertToDatabaseColumn(DeliveryStatus attribute) {
        return attribute.getCode();
    }

    @Override
    public DeliveryStatus convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(DeliveryStatus.class).stream()
                .filter(e -> e.getCode().equals(dbData))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
