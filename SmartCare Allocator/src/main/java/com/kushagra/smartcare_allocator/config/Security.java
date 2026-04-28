package com.kushagra.smartcare_allocator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/hello").authenticated()
                                .requestMatchers("/patient/**","/bedallocation/**","/bedallocation/**").hasRole("PATIENT")
                                .requestMatchers("/doctor/**").hasRole("DOCTOR")
                                .requestMatchers("/bed/**","/resource/**","/ward/**").hasRole("ADMIN")
                        .anyRequest().permitAll())
                .csrf(csrf -> csrf.disable())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
