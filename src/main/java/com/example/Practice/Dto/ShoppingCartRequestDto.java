package com.example.Practice.Dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartRequestDto {

//    @Pattern(regexp = "[1-9]\\d{0,4}")
    private Long productId;
//    @Pattern(regexp = "")
    private Integer quantity;
    @Pattern(regexp = "(?=.*[a-zA-Z0-9]).{0,20}")
    private String description;

}
