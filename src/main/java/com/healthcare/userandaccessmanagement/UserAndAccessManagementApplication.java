package com.healthcare.userandaccessmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class UserAndAccessManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAndAccessManagementApplication.class, args);
    }

}
