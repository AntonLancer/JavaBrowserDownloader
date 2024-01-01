package com.example.demo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.*;
//import jakakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestCountFilter extends GenericFilterBean {

    private final RequestCounter requestCounter;

    @Autowired
    public RequestCountFilter(RequestCounter requestCounter) {
        this.requestCounter = requestCounter;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String method = httpServletRequest.getMethod();

        if (method.equals("POST")) {
            requestCounter.incrementPostCount();
        } else if (method.equals("GET")) {
            requestCounter.incrementGetCount();
        }

        chain.doFilter(httpServletRequest, response);
    }
}

