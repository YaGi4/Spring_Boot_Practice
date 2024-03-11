package com.example.Practice.Service;

import com.example.Practice.Dto.ProductDto;
import com.example.Practice.Model.JsonModel;
import com.example.Practice.Repository.ImageRepository;
import com.example.Practice.Repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
@AllArgsConstructor
public class GetDataFromApi {

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

//    public GetDataFromApi(ProductRepository productRepository, ImageRepository imageRepository)
//    {
//        this.imageRepository = imageRepository;
//        this.productRepository = productRepository;
//    }

    public Integer getData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject("https://dummyjson.com/products", String.class);
        JsonModel jsonModel = objectMapper.readValue(jsonString, new TypeReference<>() {});
        List<ProductDto> productsDto = jsonModel.getProducts();
        for (ProductDto product : productsDto)
        {
            productRepository.addProduct(product.getBrand(), product.getCategory(), product.getDescription(),
                    product.getDiscountPercentage(), product.getId(), product.getPrice(), product.getRating(),
                    product.getStock(), product.getThumbnail(), product.getTitle());
            product.getImages().forEach(image -> imageRepository.addImage(image, product.getId()));
        }
        return 1;
    }
}
