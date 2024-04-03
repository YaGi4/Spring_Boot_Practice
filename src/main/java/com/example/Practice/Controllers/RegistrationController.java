package com.example.Practice.Controllers;

import com.example.Practice.Dto.RegistrationRequestDto;
import com.example.Practice.Service.RegisterNewUserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class RegistrationController {

    private final RegisterNewUserAccount registerNewUserAccount;

    @PostMapping("/registration")
    public void registration(@RequestBody RegistrationRequestDto registrationRequestDto){
        registerNewUserAccount.registration(registrationRequestDto);
    }
}
