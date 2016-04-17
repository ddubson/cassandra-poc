package com.ddubson.filmfox;

import com.ddubson.filmfox.services.movie.MovieService;
import com.ddubson.filmfox.services.movie.impl.MovieServiceImpl;
import com.ddubson.filmfox.services.sync.IndexingService;
import com.ddubson.filmfox.services.sync.impl.IndexingServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan(value = {
        "com.ddubson.filmfox.aop",
        "com.ddubson.filmfox.security",
        "com.ddubson.filmfox.controllers"})
@EnableAspectJAutoProxy
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    private final static String SYSTEM_LOG = "com.ddubson.filmfox.system";

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

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Forward root to webapp/index.html
        registry.addViewController("/").setViewName("/index.html");
    }
}
