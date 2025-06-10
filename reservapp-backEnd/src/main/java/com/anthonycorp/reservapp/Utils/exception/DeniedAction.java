package com.anthonycorp.reservapp.Utils.exception;

public class DeniedAction extends RuntimeException {
    public DeniedAction(String message) {
        super(message);
    }
}
