package com.raslan.votingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class VotingappApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotingappApplication.class, args);
    }
}