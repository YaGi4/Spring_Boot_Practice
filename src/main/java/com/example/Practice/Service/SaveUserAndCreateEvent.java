package com.example.Practice.Service;


import com.example.Practice.Entity.Outbox;
import com.example.Practice.Entity.User;
import com.example.Practice.Repository.OutboxRepository;
import com.example.Practice.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class SaveUserAndCreateEvent {

    private final UserRepository userRepository;
    private final OutboxRepository outboxRepository;




    @SneakyThrows
    @Transactional(rollbackFor = SQLException.class)
    public void saveUserAndEvent(User user) {
        Outbox outbox = new Outbox();
        outbox.setUserName(user.getName());
        outbox.setPhone(user.getPhone());
        outbox.setDateOfCreation(user.getDateOfCreation());
        outbox.setStatus(false);

        userRepository.save(user);
        outboxRepository.save(outbox);

        System.out.println("successful transaction");
    }
}
