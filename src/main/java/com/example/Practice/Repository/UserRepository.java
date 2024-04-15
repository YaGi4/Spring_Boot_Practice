package com.example.Practice.Repository;

import com.example.Practice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE login = :login", nativeQuery = true)
    User getUserByLogin(String login);

    @Query(value = "SELECT * FROM users WHERE phone = :phone", nativeQuery = true)
    User getUserByPhone(String phone);
}
