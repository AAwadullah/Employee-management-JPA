package com.pwc.tassignment.company.services;


import com.pwc.tassignment.company.dto.UserRegistrationDto;
import com.pwc.tassignment.company.entities.User;
import com.pwc.tassignment.company.entities.UserRoles;
import com.pwc.tassignment.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getUsername(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new UserRoles("ROLE_USER")));

        return userRepository.save(user);
    }
}
