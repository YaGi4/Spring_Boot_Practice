package com.example.Practice.ControllerTest;

import com.example.Practice.Controllers.RegistrationController;
import com.example.Practice.Dto.RegistrationRequestDto;
import com.example.Practice.Service.JwtProvider;
import com.example.Practice.Service.RegisterNewUserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterNewUserAccount registerNewUserAccount;

    @MockBean
    private JwtProvider jwtProvider;

    @Test
    public void registerNewUserAccount() {
        RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto();
        registrationRequestDto.setLogin("Login");
        registrationRequestDto.setPassword("Password");
        registrationRequestDto.setName("Name");
        registrationRequestDto.setSurname("Surname");
        registrationRequestDto.setPhone("+79278813989");
        registrationRequestDto.setProfileImageUrl("profileImageUrl");
        System.out.println("successfully registered user account");
    }
}
