package com.raslan.votingapp.controller;
import com.raslan.votingapp.model.User;
import com.raslan.votingapp.model.UserData;
import com.raslan.votingapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public Iterable<User> getUser(){
/*         user=userRepository.findByUsername("ismail");
         user.setUsername("raslan22");
         model.addAttribute("user", user);
         userRepository.save(user);*/
        return  userRepository.findAll();

    }

    @GetMapping("/{id}")
    User getOneUser(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping("/signup")
    public User postUser(@Valid @RequestBody  User user){
        userRepository.save(user);
        return user;
    }


    @PutMapping("/{id}")
    User updateUser(@Valid @RequestBody UserData userData, @PathVariable Long id ) throws Exception {
        return userRepository.findById(id).map(us -> {
            BeanUtils.copyProperties(userData , us);
            us.setId(id);
            return userRepository.save(us);
        }).get();
    }


    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
