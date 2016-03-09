package com.ddubson.cassandra.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ddubson on 3/7/16.
 */
@Configuration
public class AppConfiguration {
    @Bean
    public ObjectMapper json() {
        return new ObjectMapper();
    }
}
