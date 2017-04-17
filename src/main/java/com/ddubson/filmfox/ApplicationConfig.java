package com.ddubson.filmfox;

import com.ddubson.filmfox.services.movie.MovieService;
import com.ddubson.filmfox.services.movie.impl.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    private final static String SYSTEM_LOG = "com.ddubson.filmfox.system";
    private final static String AUTH_LOG = "com.ddubson.filmfox.auth";

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
    public Logger authLog() {
        return LoggerFactory.getLogger(AUTH_LOG);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
