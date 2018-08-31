package com.raslan.votingapp.controller;

import com.raslan.votingapp.model.LoginModel;
import com.raslan.votingapp.model.User;

import com.raslan.votingapp.repository.RoleRepository;
import com.raslan.votingapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping

public class RegisterController {

    @Autowired
    UserRepository repository;
    @Autowired
    RoleRepository roleRepository;

    LoginModel lm;


    @GetMapping("signup")
    public String getOneUser(Model model,User user){
        model.addAttribute("user",user);
        return "signup";
    }
    @PostMapping("signup")
    public String setOneUser( User user){
        user.setEnabled(true);
        user.setRole(roleRepository.findByName("ROLE_USER"));
        repository.save(user);
        return "signup";
    }

   @GetMapping
    public String getIndex(Model model, LoginModel loginModel){
        model.addAttribute("loginModel", loginModel);
        return "index";
    }
    @PostMapping
    public String postIndex(@Valid @RequestBody LoginModel loginModel){
        return "index";
    }

    @GetMapping("home")

    public String gethome(Model model, LoginModel loginModel){
        model.addAttribute("login", this.lm);
        System.out.println(this.lm.getUsername());
        return "home";
    }
    @PostMapping("home")
    public String posthome( LoginModel loginModel){
        System.out.println(loginModel.getUsername());
        return "home";
    }

    @GetMapping("users")
    public String getUsers(Model model){
        List<User> users= repository.findAll();
        model.addAttribute("users",users);
        return "users";
    }

    @PostMapping("users")
    public String users(User user){
        return "users";
    }


}
