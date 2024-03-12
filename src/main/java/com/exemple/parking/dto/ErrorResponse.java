package com.exemple.parking.dto;

import java.util.Date;

public class ErrorResponse {
    private  int code ;
    private String message;

    private Date date;

    public ErrorResponse(int code, String message, Date date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public ErrorResponse() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
