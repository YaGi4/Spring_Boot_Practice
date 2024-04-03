package com.example.Practice.Service;

import com.example.Practice.Dto.RegistrationRequestDto;
import com.example.Practice.Entity.User;
import com.example.Practice.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class RegisterNewUserAccount {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public void registration(RegistrationRequestDto registrationRequestDto){
        User user = new User();
        user.setName(registrationRequestDto.getName());
        user.setSurname(registrationRequestDto.getSurname());
        user.setPhone(registrationRequestDto.getPhone());
        user.setLogin(registrationRequestDto.getLogin());
        user.setProfileImageUrl(registrationRequestDto.getProfileImageUrl());
        user.setPassword(passwordEncoder.encode(registrationRequestDto.getPassword()));
        user.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        user.setPrivilegeLevel("user");
        user.setLocked(false);
        userRepository.save(user);
    }
}
