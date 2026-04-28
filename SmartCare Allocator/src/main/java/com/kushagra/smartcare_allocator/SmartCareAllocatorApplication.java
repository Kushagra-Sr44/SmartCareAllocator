package com.kushagra.smartcare_allocator;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebSecurity
public class SmartCareAllocatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCareAllocatorApplication.class, args);

    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
