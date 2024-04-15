package com.example.Practice.Exception;

public class UserAuthorizationException extends RuntimeException {

    public UserAuthorizationException(String message) {
        super(message);
    }
}
