package com.example.Practice.Service;

import com.example.Practice.Entity.RegistrationEventLog;
import com.example.Practice.Repository.RegistrationEventLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageBrokerService {

    private final RegistrationEventLogRepository registrationEventLogRepository;

    public void sendMessage(RegistrationEventLog registrationEventLog) {
        registrationEventLogRepository.makeTheEventComplete(registrationEventLog.getId());
        System.out.println("пользователь " + registrationEventLog.getUserName() + " зарегестрировался под номером " + registrationEventLog.getPhone());
    }
}
