package com.anthonycorp.reservapp.User.infrastructure.exception;

public class RoleNotFound extends RuntimeException {
    public RoleNotFound(String message) {
        super(message);
    }
}
