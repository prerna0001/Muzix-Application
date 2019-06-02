//ResponseForError class used in Global exception class
package com.stackroute.muzix.responses;

public class ResponseForError {
    int errorId;
    String errorMessage;

    public ResponseForError() {
    }

    public ResponseForError(int errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
