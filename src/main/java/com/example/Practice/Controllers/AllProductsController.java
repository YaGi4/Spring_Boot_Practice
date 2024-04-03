package com.example.Practice.Controllers;

import com.example.Practice.Dto.ShortProductDto;
import com.example.Practice.Service.GetAllProducts;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class AllProductsController {

    private final GetAllProducts getAllProducts;

    @GetMapping("/all")
    public List<ShortProductDto> getAllProducts(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "10") @Min(0) @Max(100) Integer limit
    ) {
        return getAllProducts.getProducts(offset, limit);
    }
}
