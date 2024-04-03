package com.example.Practice.Service;

import com.example.Practice.Dto.ExtendedProductDto;
import com.example.Practice.Entity.Product;
import com.example.Practice.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProduct {
    private final ProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ExtendedProductDto getProduct(Long id){
        Product productEntity = productRepository.getProductById(id);
        return mapper.map(productEntity, ExtendedProductDto.class);
    }
}
