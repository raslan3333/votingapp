package com.raslan.votingapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.transaction.TransactionScoped;


@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/users/signup").setViewName("signup");

    }
}
