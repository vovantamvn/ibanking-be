package io.spring.app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperProvide {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
