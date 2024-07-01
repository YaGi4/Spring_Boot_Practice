package com.example.Practice.TelegramBot;

import com.example.Practice.Service.SaveDataFromApiInDatabase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelegramBotLogicService {
    private final SaveDataFromApiInDatabase saveDataInDatabase;

    @SneakyThrows
    public String botLogic(String requestText){
        if(requestText.equals("/start")){
            return "Hello Friend!";
        }
        else if(requestText.equals("/updateData")){
            saveDataInDatabase.saveDataInDatabase();
            return "update data!";
        }
        return "??";
    }
}
