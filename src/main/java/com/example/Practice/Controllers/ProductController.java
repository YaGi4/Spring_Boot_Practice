package com.example.Practice.Controllers;

import com.example.Practice.Dto.ExtendedProductDto;
import com.example.Practice.Dto.ShortProductDto;
import com.example.Practice.Service.GetAllProducts;
import com.example.Practice.Service.GetProduct;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    public final GetProduct getProduct;
    public final GetAllProducts getallProducts;

    @GetMapping("/{id}")
    public ExtendedProductDto getProduct(@PathVariable Long id) {
        return getProduct.getProduct(id);
    }

    @GetMapping("/all")
    public List<ShortProductDto> getAllProducts(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "10") @Min(1) @Max(100) Integer limit
    ) {
        return getallProducts.getProducts(offset, limit);
    } 
}
