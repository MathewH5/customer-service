package com.mathew.customer.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CallerInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CallerInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {

        String caller = request.getHeader("X-Service-Caller");

        if (caller == null){
            caller = "unknown";
        }

        String endpoint = request.getRequestURI();
        String method = request.getMethod();

        log.info("{} chamou {} {}", caller, method, endpoint);

        return true;
    }
}
