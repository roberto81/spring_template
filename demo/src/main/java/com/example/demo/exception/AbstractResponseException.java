package com.example.demo.exception;

public abstract class AbstractResponseException {

    private String httpStatus;
    public AbstractResponseException(){

    }

    public AbstractResponseException(String httpStatus){
        this.httpStatus = httpStatus;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
