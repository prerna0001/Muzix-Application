package com.stackroute.muzix.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrackNotFoundException extends Exception {
    public String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
