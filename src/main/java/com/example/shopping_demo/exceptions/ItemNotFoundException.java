package com.example.shopping_demo.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
