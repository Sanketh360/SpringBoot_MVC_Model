package com.example.spring_fizal.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UserNotFoundException.class ,IllegalArgumentException.class , NullPointerException.class})
    public ResponseEntity<Map<String , Object>> handleIllegalArgumentException(Exception exception){
        Map<String , Object> errorResponse = new HashMap<>();
        errorResponse.put("Message" , exception.getMessage());
        return  new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String , Object>> handleMethodNotSupported(Exception exception){
        Map<String , Object> errorResponse = new HashMap<>();
        errorResponse.put("Message" , exception.getMessage());
        return  new ResponseEntity<>(errorResponse , HttpStatus.METHOD_NOT_ALLOWED);
    }

}
