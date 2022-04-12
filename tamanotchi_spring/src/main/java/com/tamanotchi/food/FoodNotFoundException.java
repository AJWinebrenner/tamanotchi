package com.tamanotchi.food;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException (String message) {
        super(message);
    }
}
