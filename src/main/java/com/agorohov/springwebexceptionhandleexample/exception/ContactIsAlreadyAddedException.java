package com.agorohov.springwebexceptionhandleexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContactIsAlreadyAddedException extends RuntimeException {
    public ContactIsAlreadyAddedException() {
    }

    public ContactIsAlreadyAddedException(String message) {
        super(message);
    }

    public ContactIsAlreadyAddedException(String message,
                                          Throwable cause) {
        super(message, cause);
    }

    public ContactIsAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public ContactIsAlreadyAddedException(String message,
                                          Throwable cause,
                                          boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
