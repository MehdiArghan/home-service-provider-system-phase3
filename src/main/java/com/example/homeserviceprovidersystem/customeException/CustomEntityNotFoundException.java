package com.example.homeserviceprovidersystem.customeException;

import jakarta.persistence.EntityNotFoundException;

public class CustomEntityNotFoundException extends EntityNotFoundException {
    public CustomEntityNotFoundException(String message) {
        super(message);
    }
}
