package com.exemple.parking.exception;

import com.exemple.parking.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandlerParking {
    @ExceptionHandler(ParkingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleParkingNotFoundException(ParkingNotFoundException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setDate(new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(NullPointerException ex){
        ErrorResponse response = new ErrorResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage("il est null ");
        response.setDate(new Date());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

