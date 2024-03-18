package com.example.Practice.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiProductDto
{
    private Long id;
    private String title;
    private String description;
    private Float price;
    private Float discountPercentage;
    private Float rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;
}
