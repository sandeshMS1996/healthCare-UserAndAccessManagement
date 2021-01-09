package com.healthcare.userandaccessmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class UserAndAccessManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAndAccessManagementApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/oauth/token").allowedOrigins("http://localhost:4200");
            }
        };
        return webMvcConfigurer;
    }
}
