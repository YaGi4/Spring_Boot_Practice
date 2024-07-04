package com.example.Practice.Service;


import com.example.Practice.Dto.ShortUserInfoDto;
import com.example.Practice.Entity.User;
import com.example.Practice.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class SaveUserAndCreateEvent {

    private final UserRepository userRepository;
    private KafkaTemplate<String, String> kafkaTemplate;


    @SneakyThrows
    @Transactional(rollbackFor = SQLException.class)
    public void saveUserAndEvent(User user) {
        ShortUserInfoDto shortUserInfoDto = new ShortUserInfoDto();
        shortUserInfoDto.setUserName(user.getName());
        shortUserInfoDto.setPhone(user.getPhone());
        shortUserInfoDto.setDateOfRegistration(user.getDateOfCreation());

        kafkaTemplate.send("phoneMessage", new ObjectMapper().writeValueAsString(shortUserInfoDto));
        userRepository.save(user);
        System.out.println("successful transaction");
    }
}
