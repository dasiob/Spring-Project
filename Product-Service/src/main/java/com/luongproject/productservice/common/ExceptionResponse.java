package com.luongproject.productservice.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ExceptionResponse extends Exception {
    private final HttpStatus status;

    public ExceptionResponse(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
