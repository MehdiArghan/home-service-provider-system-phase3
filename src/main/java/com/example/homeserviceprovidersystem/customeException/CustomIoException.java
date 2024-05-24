package com.example.homeserviceprovidersystem.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomIoException extends IOException {
    public CustomIoException() {
    }

    public CustomIoException(String message) {
        super(message);
    }

    public CustomIoException(String message, Throwable cause) {
        super(message, cause);
    }
}
