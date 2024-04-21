package com.example.Practice.Dto;

import lombok.Data;

@Data
public class ShoppingCartDto {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private String description;
}
