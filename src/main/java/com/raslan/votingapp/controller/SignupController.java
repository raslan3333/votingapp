package com.raslan.votingapp.controller;

import com.raslan.votingapp.model.User;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SignupController {

    @Autowired
    UserRepository repository;

    @GetMapping("/signup")
    public String getOneUser( Model model, User user){
        model.addAttribute("user",user);
         return "signup";
    }
    @PostMapping("/signup")
    public String setOneUser( Model model, User user){
        model.addAttribute("user",user);
        repository.save(user);
         return "signup";
    }
}
