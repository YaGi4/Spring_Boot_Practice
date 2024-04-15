package com.example.Practice.Controllers;

import com.example.Practice.Dto.ExtendedProductDto;
import com.example.Practice.Service.GetProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    public final GetProduct getProduct;

    @GetMapping("/{id}")
    public ExtendedProductDto getProduct(@PathVariable Long id) {
        return getProduct.getProduct(id);
    }
}
