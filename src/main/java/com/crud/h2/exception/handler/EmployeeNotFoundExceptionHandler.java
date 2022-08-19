package com.crud.h2.exception.handler;

import com.crud.h2.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeNotFoundExceptionHandler {
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> exception(EmployeeNotFoundException ee) {
        return new ResponseEntity<Object>("Employee Not Found !!", HttpStatus.NOT_FOUND);
    }
}