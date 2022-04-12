package com.tamanotchi.variant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VariantNotFoundException extends RuntimeException{
    public VariantNotFoundException(String message) {
        super(message);
    }
}
