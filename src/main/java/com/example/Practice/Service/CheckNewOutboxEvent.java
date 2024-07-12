package com.example.Practice.Service;

import com.example.Practice.Dto.ShortUserInfoDto;
import com.example.Practice.Entity.Outbox;
import com.example.Practice.Repository.OutboxRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class CheckNewOutboxEvent {

    private final OutboxRepository outboxRepository;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 5000)
    public void CheckNewOutboxEvent() {
        List<Outbox> outboxList = outboxRepository.findAllByStatusFalse();

        for (Outbox outbox : outboxList) {
            SendToBroker(outbox);
        }
    }

    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    protected void SendToBroker(Outbox outbox) {
        ShortUserInfoDto shortUserInfoDto = new ShortUserInfoDto();
        shortUserInfoDto.setUserName(outbox.getUserName());
        shortUserInfoDto.setPhone(outbox.getPhone());
        shortUserInfoDto.setDateOfRegistration(outbox.getDateOfCreation());
        kafkaTemplate.send("phoneMessage", new ObjectMapper().writeValueAsString(shortUserInfoDto));
        outbox.setStatus(true);
        outboxRepository.save(outbox);
    }
}
