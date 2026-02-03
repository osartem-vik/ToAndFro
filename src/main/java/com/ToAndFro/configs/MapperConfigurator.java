package com.ToAndFro.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigurator {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
