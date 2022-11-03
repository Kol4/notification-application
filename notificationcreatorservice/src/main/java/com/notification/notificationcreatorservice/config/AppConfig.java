package com.notification.notificationcreatorservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Beans config.
 */
@Configuration
public class AppConfig {

    /**
     * Creates ModelMapper bean.
     *
     * @return new {@link ModelMapper}
     */
    @Bean
    @RequestScope
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
