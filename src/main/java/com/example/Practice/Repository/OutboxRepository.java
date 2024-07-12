package com.example.Practice.Repository;

import com.example.Practice.Entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OutboxRepository extends JpaRepository<Outbox, Long> {

    @Query(value = "SELECT * FROM outbox WHERE status = false", nativeQuery = true)
    List<Outbox> findAllByStatusFalse();
}
