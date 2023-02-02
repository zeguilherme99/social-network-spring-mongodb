package com.learning.socialnetwork.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String id) {
        super("User not found. Id: " + id);
    }
}
