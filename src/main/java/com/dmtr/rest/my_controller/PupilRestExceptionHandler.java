package com.dmtr.rest.my_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class PupilRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PupilErrorResponse> handlerException(PupilNotFoundException exception){
        PupilErrorResponse error = new PupilErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PupilErrorResponse>  handlerException(MethodArgumentTypeMismatchException exception){
        PupilErrorResponse error = new PupilErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("User enter invalid data. You must enter only INTEGER value");
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
