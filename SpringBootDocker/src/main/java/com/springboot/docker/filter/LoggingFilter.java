package com.springboot.docker.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        requestLog((HttpServletRequest) request);
        chain.doFilter(request, response);
        responseLog((HttpServletResponse) response);

    }

    private void requestLog(HttpServletRequest request) {
        Enumeration headerNames = request.getHeaderNames();
        System.out.println("■■■■■■■ request header■■■■■■■  :" + request.getServletPath());
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + ":" + value);
        }
    }

    private void responseLog(HttpServletResponse response) {
        System.out.println("■■■■■■■ response header■■■■■■■");
        System.out.println("httpstatus:" + response.getStatus());
        for (String headerName : response.getHeaderNames()) {
            String value = response.getHeader(headerName);
            System.out.println(headerName + ":" + value);
        }
    }

}
