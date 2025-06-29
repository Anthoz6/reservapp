package com.anthonycorp.reservapp.Utils.exception;

public class TokenExpiredException  extends RuntimeException {
    public TokenExpiredException (String message) {
        super(message);
    }
}
