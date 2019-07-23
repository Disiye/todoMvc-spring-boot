package com.thoughtworks.todomvc.exception;

import org.springframework.http.HttpStatus;

public class ItemNotNniqueException extends Exception {
    private HttpStatus errorCode;

    public ItemNotNniqueException(String message) {
        super(message);
        this.errorCode = HttpStatus.BAD_REQUEST;
    }

}
