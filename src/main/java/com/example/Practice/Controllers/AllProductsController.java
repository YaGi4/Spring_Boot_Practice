package com.example.Practice.Controllers;

import com.example.Practice.Dto.ShortProductDto;
import com.example.Practice.Repository.ProductRepository;
import com.example.Practice.Service.ConvertProductEntityToDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AllProductsController {

    private final ProductRepository productRepository;

    @GetMapping("/product/all")
    public List<ShortProductDto> getAllProducts(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "10") @Min(0) @Max(100) Integer limit
    )
    {
        return ConvertProductEntityToDto.convert(productRepository.getAll(PageRequest.of(offset, limit)));
    }
}
