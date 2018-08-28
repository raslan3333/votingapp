package com.raslan.votingapp.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.raslan.votingapp.model.User;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import javax.validation.Valid;
import java.lang.reflect.Array;

@RestController
@RequestMapping("users")
public class UserController {


    final
    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public User getUser(){
        return userRepository.findByUsername("raslan");
    }

    @PostMapping("/signup")
    public User postUser(@Valid @RequestBody  User user ){

        System.out.println(user.getUsername());
        userRepository.save(user);
        return user;
    }

    @PutMapping
    public String updateUser(){
        return "update user";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user";
    }



}
