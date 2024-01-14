package com.leancoder.interceptores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.leancoder.models.domains.Country;

@Configuration
public class BeansConfig {
    
    @Bean
    @SessionScope
    Country initCountry() {
        return new Country("");
    }

}
