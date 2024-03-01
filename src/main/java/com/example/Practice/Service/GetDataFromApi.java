package com.example.Practice.Service;

import com.example.Practice.Model.JsonModel;
import com.example.Practice.Model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GetDataFromApi {
    public static List<Product> getData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject("https://dummyjson.com/products", String.class);
        JsonModel jsonModel = objectMapper.readValue(jsonString, new TypeReference<>() {});
        return jsonModel.getProducts() ;
    }
}
