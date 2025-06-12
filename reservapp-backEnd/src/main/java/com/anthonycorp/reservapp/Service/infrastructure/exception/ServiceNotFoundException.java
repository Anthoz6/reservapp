package com.anthonycorp.reservapp.Service.infrastructure.exception;

public class ServiceNotFoundException extends RuntimeException{
    public ServiceNotFoundException(String message) {
        super(message);
    }
}
