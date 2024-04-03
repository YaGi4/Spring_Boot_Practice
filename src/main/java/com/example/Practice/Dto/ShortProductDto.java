package com.example.Practice.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShortProductDto
{
    private Long id;
    private String title = null;
    private Float price = null;
    private Float discountPercentage = null;
    private Float rating = null;
    @JsonProperty("imageList")
    private List<ImageDto> images = new ArrayList<>();
}


