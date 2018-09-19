package com.raslan.votingapp.controller;

import com.raslan.votingapp.model.User;
import com.raslan.votingapp.model.UserData;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping
public class UserController {


    final UserRepository userRepository;

    User user;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @GetMapping("/user/{id}")
    public User getOneUser(@PathVariable Long id){
        return userRepository.findById(id).get();
    }



    @PutMapping("/user/{id}")
    public User updateUser(@Valid @RequestBody UserData userData, @PathVariable Long id) throws Exception {
        return userRepository.findById(id).map(us -> {
            BeanUtils.copyProperties(userData , us);
            us.setId(id);
            return userRepository.save(us);
        }).get();
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }



}
