package com.example.Practice.Service;

import com.example.Practice.Dto.ExtendedProductDto;
import com.example.Practice.Entity.Product;
import com.example.Practice.Exception.ProductNotFoundException;
import com.example.Practice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProduct {
    private final ProductRepository productRepository;
    private ModelMapper mapper = new ModelMapper();

    @Cacheable(value = "productCache")
    public ExtendedProductDto getProduct(Long id) {
        Product productEntity = productRepository.getProductById(id);
        if(productEntity == null){
            throw new ProductNotFoundException("Product not found");
        }
        return mapper.map(productEntity, ExtendedProductDto.class);
    }
}
