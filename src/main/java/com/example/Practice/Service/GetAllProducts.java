package com.example.Practice.Service;

import com.example.Practice.Dto.ShortProductDto;
import com.example.Practice.Entity.Product;
import com.example.Practice.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GetAllProducts {
    private final ProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();
    public List<ShortProductDto> getProducts(Integer offset, Integer limit){
        List<ShortProductDto> shortProductDto = new ArrayList<>();
        for (Product product : productRepository.getAll(PageRequest.of(offset, limit))) {
            shortProductDto.add(mapper.map(product, ShortProductDto.class));
        }
        return shortProductDto;
    }
}
