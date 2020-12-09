package com.javatab.exception;

public class NoUserFoundException extends RuntimeException {

    public NoUserFoundException(String username) {
        super(String.format("No user found with username '%s'.", username));
    }
}
