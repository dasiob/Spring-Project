package com.luongbd.productservice.common;

import org.springframework.http.HttpStatus;

public class ExceptionResponse extends Exception {
    private final HttpStatus status;

    public ExceptionResponse(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
