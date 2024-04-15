package com.example.Practice.Exception;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException(String message) {
        super(message);
    }
}
