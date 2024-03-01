package com.example.Practice.Controllers;

import com.example.Practice.Model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Practice.Service.GetDataFromApi;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/test")
    public List<Product> getInfo() throws JsonProcessingException {
        return GetDataFromApi.getData();
    }
}
