package com.example.Practice.Dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorStatusDto {
    private Date timeStamp;
    private HttpStatus statusCode;
    private Integer errorCode;
    private Integer androidErrorCode;
    private String message;
}