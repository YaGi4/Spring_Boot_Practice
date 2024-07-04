package com.example.Practice.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class ShortUserInfoDto {

    private String userName;
    private String phone;
    private Date dateOfRegistration;
}