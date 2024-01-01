package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    private final RequestCounter requestCounter;

    @Autowired
    public WebConfig(RequestCounter requestCounter) {
        this.requestCounter = requestCounter;
    }

    @Bean
    public FilterRegistrationBean<RequestCountFilter> loggingFilter(){
        FilterRegistrationBean<RequestCountFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestCountFilter(requestCounter));
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
