package com.javatab.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NoUserFoundException extends UsernameNotFoundException {

    private static final long serialVersionUID = -3284993425429534536L;

    public NoUserFoundException(String username) {
        super(String.format("No user found with username '%s'.", username));
    }
}
