package com.anthonycorp.reservapp.User.infrastructure.exception;

public class InvalidRole extends RuntimeException {
    public InvalidRole(String message) {
        super(message);
    }
}
