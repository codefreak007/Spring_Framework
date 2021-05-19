package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handles specific exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler(ResourceNotFoundException ex, WebRequest req){

        ErrorDetails detail=new ErrorDetails(new Date(),ex.getMessage(), req.getDescription(false));
        return new ResponseEntity(detail, HttpStatus.NO_CONTENT);
    }

    //Handles all other exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericExceptionHandler(Exception ex, WebRequest req){

        ErrorDetails detail=new ErrorDetails(new Date(),ex.getMessage(), req.getDescription(false));
        return new ResponseEntity(detail, HttpStatus.NO_CONTENT);
    }
}
