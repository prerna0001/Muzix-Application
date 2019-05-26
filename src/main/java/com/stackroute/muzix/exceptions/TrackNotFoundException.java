package com.stackroute.muzix.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrackNotFoundException extends Exception {
    public String msg;

    public TrackNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
