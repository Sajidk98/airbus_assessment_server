package com.example.shopping_demo.exceptions;

public class OutOfStockException extends RuntimeException{
    public OutOfStockException(String message) {
        super(message);
    }
}

