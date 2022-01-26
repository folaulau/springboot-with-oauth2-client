package com.lovemesomecoding.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovemesomecoding.oauth2.utils.ObjectMapperUtils;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = ObjectMapperUtils.getObjectMapper();
        return objectMapper;
    }
}
