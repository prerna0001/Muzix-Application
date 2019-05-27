package com.stackroute.muzix.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrackAlreadyExistsException extends Exception {
    private String message;

    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
