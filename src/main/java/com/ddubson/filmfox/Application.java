package com.ddubson.filmfox;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@Component
class Application {
    @Autowired
    Logger sysLog;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener
    public void appStarted(ContextRefreshedEvent e) {
        sysLog.info("Application started.");
    }

    @EventListener
    public void appStopped(ContextClosedEvent e) {
        sysLog.info("Application stopped.");
    }
}
