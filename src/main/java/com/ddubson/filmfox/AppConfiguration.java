package com.ddubson.filmfox;

import com.ddubson.filmfox.services.MovieService;
import com.ddubson.filmfox.services.impl.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by ddubson on 3/7/16.
 */
@Configuration
public class AppConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MovieService movieService() {
        return new MovieServiceImpl();
    }

    @Bean
    public ObjectMapper json() {
        return new ObjectMapper();
    }

    @Bean
    public Logger sysLog() {
        return LoggerFactory.getLogger("com.ddubson.filmfox.system");
    }
}
