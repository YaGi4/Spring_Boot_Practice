package com.example.Practice.Service;


import com.example.Practice.Entity.RegistrationEventLog;
import com.example.Practice.Entity.User;
import com.example.Practice.Repository.RegistrationEventLogRepository;
import com.example.Practice.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class SaveUserAndCreateEvent {

    private final UserRepository userRepository;
    private final RegistrationEventLogRepository registrationEventLogRepository;


    @Transactional(rollbackFor = SQLException.class)
    public void saveUserAndEvent(User user) {
        RegistrationEventLog eventLog = new RegistrationEventLog();
        eventLog.setDateOfCreation(user.getDateOfCreation());
        eventLog.setPhone(user.getPhone());
        eventLog.setUserName(user.getName());
        eventLog.setWasDone(false);

        registrationEventLogRepository.save(eventLog);
        userRepository.save(user);
    }
}
