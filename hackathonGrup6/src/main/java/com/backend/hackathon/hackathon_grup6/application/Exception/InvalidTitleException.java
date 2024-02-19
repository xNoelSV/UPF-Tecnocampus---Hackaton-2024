package com.backend.hackathon.hackathon_grup6.application.Exception;

public class InvalidTitleException extends RuntimeException {
    public InvalidTitleException() {
        super("Title must start with an uppercase letter");
    }
}
