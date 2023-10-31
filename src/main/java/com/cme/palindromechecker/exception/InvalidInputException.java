package com.cme.palindromechecker.exception;

// Create for customer exception message
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
