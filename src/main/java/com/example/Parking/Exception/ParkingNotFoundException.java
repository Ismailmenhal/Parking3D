package com.example.Parking.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ParkingNotFoundException extends RuntimeException{
    public ParkingNotFoundException(String message, Long id){
        super(message);
    }
}
