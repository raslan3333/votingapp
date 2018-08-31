package com.raslan.votingapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Autowired
    HttpSession session;


    @Autowired
    private Environment env;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {


        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/users/signup").setViewName("signup");



    }



}
