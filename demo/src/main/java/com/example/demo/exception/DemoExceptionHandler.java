package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    protected ResponseEntity<ResponseMessageException> entityNotFoundException(EntityNotFoundException ex){
            return new ResponseEntity<ResponseMessageException>(new ResponseMessageException(ex.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

}
