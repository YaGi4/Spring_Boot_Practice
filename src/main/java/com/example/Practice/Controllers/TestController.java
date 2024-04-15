package com.example.Practice.Controllers;

import com.example.Practice.Service.SaveDataFromApiInDatabase;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final SaveDataFromApiInDatabase saveDataInDatabase;

    @GetMapping("/getData")
    public void getInfo() throws JsonProcessingException {
        saveDataInDatabase.saveDataInDatabase();
    }
}
