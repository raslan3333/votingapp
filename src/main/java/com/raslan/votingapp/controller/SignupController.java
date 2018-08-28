package com.raslan.votingapp.controller;

import com.raslan.votingapp.model.User;
import com.raslan.votingapp.repository.RoleRepository;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("users")
public class SignupController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("signup")
    public String signup(Model model){
        User user = userRepository.findByUsername("raslan");
        model.addAttribute("user", user);
        return "signup";
    }


}
