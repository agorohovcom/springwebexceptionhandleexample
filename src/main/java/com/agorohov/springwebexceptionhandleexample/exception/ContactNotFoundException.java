package com.agorohov.springwebexceptionhandleexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException() {
    }

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(String message,
                                    Throwable cause) {
        super(message, cause);
    }

    public ContactNotFoundException(Throwable cause) {
        super(cause);
    }

    public ContactNotFoundException(String message,
                                    Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
