package com.stackroute.muzix.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrackAlreadyExistsException extends Exception {
    private String msg;

    public TrackAlreadyExistsException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
