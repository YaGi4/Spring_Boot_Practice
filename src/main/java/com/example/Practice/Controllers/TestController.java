package com.example.Practice.Controllers;

import com.example.Practice.Dto.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Practice.Service.GetDataFromApi;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final GetDataFromApi getDataFromApi;
    @GetMapping("/getData")
    public String getInfo() throws JsonProcessingException {
        Integer flag = getDataFromApi.getData();
        return "Success";
    }
}
