package com.pwc.tassignment.company.services;
import com.pwc.tassignment.company.dto.UserRegistrationDto;
import com.pwc.tassignment.company.entities.User;
import com.pwc.tassignment.company.entities.UserRoles;
import com.pwc.tassignment.company.pojos.MyUserDetails;
import com.pwc.tassignment.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;





    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

}