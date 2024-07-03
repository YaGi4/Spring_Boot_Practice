package com.example.Practice.Service;

import com.example.Practice.Dto.RegistrationRequestDto;
import com.example.Practice.Entity.User;
import com.example.Practice.Exception.UserAuthorizationException;
import com.example.Practice.Repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;

@Service
@Validated
@AllArgsConstructor
public class RegisterNewUserAccount {

    private final PasswordEncoder passwordEncoder;
    private final SaveUserAndCreateEvent saveUserAndCreateEvent;
    private final UserRepository userRepository;
    public void register(@Valid RegistrationRequestDto registrationRequestDto) {
        if(userRepository.getUserByPhone(registrationRequestDto.getPhone()) != null) {
            throw new UserAuthorizationException("A user with this phone number already exists");
        } else if (userRepository.getUserByLogin(registrationRequestDto.getLogin()) != null) {
            throw new UserAuthorizationException("a user with this login already exists");
        }
        User user = new User();

        user.setName(registrationRequestDto.getName());
        user.setSurname(registrationRequestDto.getSurname());
        user.setPhone(registrationRequestDto.getPhone());
        user.setLogin(registrationRequestDto.getLogin());
        user.setProfileImageUrl(registrationRequestDto.getProfileImageUrl());
        user.setPassword(passwordEncoder.encode(registrationRequestDto.getPassword()));
        user.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        user.setPrivilegeLevel("USER");
        user.setLocked(false);

        saveUserAndCreateEvent.saveUserAndEvent(user);
    }
}
