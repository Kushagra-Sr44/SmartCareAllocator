package com.kushagra.smartcare_allocator.service;

import com.kushagra.smartcare_allocator.entity.User;
import com.kushagra.smartcare_allocator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user=userRepository.findByuserName(username);
        if(user==null) throw new UsernameNotFoundException(username+"not found");
        UserDetails userDetails= org.springframework.security.core.userdetails.User.
                withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
        return userDetails;

    }

}
