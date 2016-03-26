package com.ddubson.filmfox;

import com.ddubson.filmfox.services.movie.MovieService;
import com.ddubson.filmfox.services.movie.impl.MovieServiceImpl;
import com.ddubson.filmfox.services.sync.IndexingService;
import com.ddubson.filmfox.services.sync.impl.IndexingServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAsync
@EnableScheduling
public class ApplicationConfig {
    public final static String SYSTEM_LOG = "com.ddubson.filmfox.system";
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
        return LoggerFactory.getLogger(SYSTEM_LOG);
    }

    @Bean
    public IndexingService indexingService() {
        return new IndexingServiceImpl();
    }
}
