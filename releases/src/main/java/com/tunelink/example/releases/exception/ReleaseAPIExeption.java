package com.tunelink.example.releases.exception;

import org.springframework.http.HttpStatus;

public class ReleaseAPIExeption extends RuntimeException {
    private HttpStatus status;
    private String message;

    public ReleaseAPIExeption(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ReleaseAPIExeption(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
