package com.tae.hoon.speciallist.item.customException;

import com.tae.hoon.speciallist.exception.SpecialListException;

public class ItemSeqNotProvidedProperlyException extends SpecialListException {
    public ItemSeqNotProvidedProperlyException() {
        super();
    }

    public ItemSeqNotProvidedProperlyException(String message) {
        super(message);
    }
}
