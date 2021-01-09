package com.healthcare.userandaccessmanagement.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getAuthType() + "authtype");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s + " ====> " + request.getHeader(s));
        }
        System.out.println(request.getParameterMap() + " requet params");
        System.out.println(request.getRequestURI() + "uri");
        System.out.println(request.getHeaderNames() + " header names");
        filterChain.doFilter(request, response);
    }
}
