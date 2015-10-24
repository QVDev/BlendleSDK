package com.sdk.response;

public class ErrorResponse {
    private String message;

    public ErrorResponse(String receiveMessage) {
        message = receiveMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
