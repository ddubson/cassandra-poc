package com.ddubson.filmfox;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ddubson on 3/9/16.
 */
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Forward root to webapp/index.html
        registry.addViewController("/").setViewName("/index.html");
    }
}
