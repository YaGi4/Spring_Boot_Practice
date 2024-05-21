package com.example.Practice.Service;

import com.example.Practice.Dto.ApiProductDto;
import com.example.Practice.Model.JsonModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
@AllArgsConstructor
public class GetDataFromApi {
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<ApiProductDto> getDataFromApi() throws JsonProcessingException {
        String jsonString = restTemplate.getForObject("https://dummyjson.com/products", String.class);
        JsonModel jsonModel = objectMapper.readValue(jsonString, new TypeReference<>() {});
        return jsonModel.getProducts();
    }
}