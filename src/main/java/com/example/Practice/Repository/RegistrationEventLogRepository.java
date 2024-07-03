package com.example.Practice.Repository;

import com.example.Practice.Entity.RegistrationEventLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RegistrationEventLogRepository extends JpaRepository<RegistrationEventLog, Long> {

    @Query(value = "SELECT * FROM registration_event_log WHERE was_done = false ORDER BY date_of_creation LIMIT 1", nativeQuery = true)
    RegistrationEventLog getLastEvent();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE registration_event_log SET was_done = true WHERE id = :id", nativeQuery = true)
    void makeTheEventComplete(Long id);
}
