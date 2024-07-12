package com.example.Practice.ServiceTest;

import com.example.Practice.Entity.User;
import com.example.Practice.Filter.JwtFilter;
import com.example.Practice.Repository.UserRepository;
import com.example.Practice.Service.RegisterNewUserAccount;
import com.example.Practice.Service.SaveUserAndCreateEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterNewUserAccount.class)
public class RegisterServiceController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    private SaveUserAndCreateEvent saveUserAndCreateEvent;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private JwtFilter jwtFilter;

    @Test
    public void registerTest() {
        User user = new User();
        user.setName("Test User");
        user.setSurname("Test Surname");
        user.setPhone("+71234567895");
        user.setLogin("Test Login");
        user.setProfileImageUrl("Test Profile Image");
        user.setPassword("password");
        user.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        user.setPrivilegeLevel("USER");
        user.setLocked(false);

        saveUserAndCreateEvent.saveUserAndEvent(user);
        System.out.println("Registered Successfully");
    }
}
