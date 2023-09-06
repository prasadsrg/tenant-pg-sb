package com.tenant.config;

import org.springframework.http.HttpStatus;

import java.util.List;

public class AppException extends RuntimeException{
    private HttpStatus status;
    private List<String> messages;

    public AppException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }

    public AppException(String message){
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public AppException(HttpStatus status, List<String> messages){
        super(messages.toString());
        this.status = status;
        this.messages = messages;
    }

    public AppException(List<String> messages){
        super(messages.toString());
        this.status = HttpStatus.BAD_REQUEST;
        this.messages = messages;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public List<String> getMessages(){
        return this.messages;
    }
}
