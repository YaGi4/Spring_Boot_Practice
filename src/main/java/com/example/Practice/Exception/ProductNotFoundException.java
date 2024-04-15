package com.example.Practice.Exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);
    }
}
