package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ResponseMessageException extends AbstractResponseException{
    private String message;

    public ResponseMessageException(){ }

    public ResponseMessageException(String message, HttpStatus httpStatus){
        super(httpStatus.toString());
        this.message = message;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }
}
