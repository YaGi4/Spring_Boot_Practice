package com.example.Practice.Service;

import com.example.Practice.Entity.RegistrationEventLog;
import com.example.Practice.Repository.RegistrationEventLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageRelayService {

    private final MessageBrokerService messageBrokerService;
    private final RegistrationEventLogRepository registrationEventLogRepository;

    @Scheduled(fixedRate = 5000)
    public void getEventAndPublish() {
        RegistrationEventLog registrationEventLog = registrationEventLogRepository.getLastEvent();
        if(registrationEventLog == null) {
            System.out.println("No event found");
        }
        else {
            messageBrokerService.sendMessage(registrationEventLog);
        }
    }
}
