package com.hcaglar.ticketapplication.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 5.01.2023
 */
@Configuration
public class SecurityBeans {

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder(12);
    }

}
