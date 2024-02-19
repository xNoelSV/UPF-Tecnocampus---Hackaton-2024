package com.backend.hackathon.hackathon_grup6.application.Exception;

public class InvalidPriceException extends RuntimeException{
    public InvalidPriceException(double price) {
        super("Price cannot be negative");
    }
}
