package com.backend.hackathon.hackathon_grup6.application.Exception;

public class DuplicateEventsTitleException extends RuntimeException{
    public DuplicateEventsTitleException(String title) {
        super("Course with title " + title + " already exists");
    }
}
