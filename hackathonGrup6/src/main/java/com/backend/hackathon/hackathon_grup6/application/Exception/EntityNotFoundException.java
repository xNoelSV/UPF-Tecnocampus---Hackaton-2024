package com.backend.hackathon.hackathon_grup6.application.Exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Class entity, Object value){
        super("Entity " + entity.getName() + " not found with id " + value );
    }
}
