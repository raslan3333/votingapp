package com.raslan.votingapp.controller;

import com.raslan.votingapp.model.User;
import com.raslan.votingapp.model.UserData;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {


    final UserRepository userRepository;

    User user;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @GetMapping("/users/{id}")
    User getOneUser(@PathVariable Long id){
        return userRepository.findById(id).get();
    }



    @PutMapping("/users/{id}")
    User updateUser(@Valid @RequestBody UserData userData, @PathVariable Long id) throws Exception {
        return userRepository.findById(id).map(us -> {
            BeanUtils.copyProperties(userData , us);
            us.setId(id);
            return userRepository.save(us);
        }).get();
    }


    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }



}
