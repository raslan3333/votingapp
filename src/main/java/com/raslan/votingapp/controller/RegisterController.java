package com.raslan.votingapp.controller;


import com.raslan.votingapp.model.User;
import com.raslan.votingapp.repository.RoleRepository;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping

public class RegisterController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;



    @GetMapping("home")
    public String index(Model model){
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUserName);
        model.addAttribute("currentUser", currentUser);
        return "home";
    }


    @GetMapping("signup")
    public String getOneUser(Model model, User user){
        model.addAttribute("user",user);
        return "signup";
    }


    @PostMapping("signup")
    public String setOneUser(Model model, User user){
        user.setEnabled(true);
        user.setRole(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
        model.addAttribute("currentUser", user);
        return "home";
    }


    @GetMapping("users")
    public String getUsers(Model model){
        List<User> users= userRepository.findAll();
        model.addAttribute("users",users);
        return "users";
    }

    @PostMapping("users")
    public String users(User user){
        return "users";
    }


}
