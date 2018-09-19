package com.raslan.votingapp.controller;

import com.raslan.votingapp.model.User;
import com.raslan.votingapp.repository.RoleRepository;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping

public class RegisterController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("home")
    public String index(Model model) {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUserName);
        model.addAttribute("currentUser", currentUser);
        return "home";
    }


    @GetMapping("signup")
    public String getOneUser(Model model, User user) {
        model.addAttribute("user", user);
        return "signup";
    }


    @PostMapping("signup")
    public String setOneUser(Model model, User user) {
        user.setEnabled(true);
        user.setRole(roleRepository.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("currentUser", user);
        return "home";
    }


    @GetMapping("users")
    public String getUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("users")
    public String users(User user) {
        return "users";
    }

    @GetMapping
    public String index(HttpServletResponse res) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = auth.getAuthorities().stream().anyMatch(role -> role.getAuthority().contains("ROLE_ADMIN"));
        String[] hasAnyRole = auth.getAuthorities().toString().split("\\W+");
        List<String> arrayList = new ArrayList<>(Arrays.asList(hasAnyRole));

        if (arrayList.contains("ROLE_USER") || arrayList.contains("ROLE_ADMIN")) {
            try {
                res.sendRedirect("/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletResponse res) {
        return index(res);
    }

}
