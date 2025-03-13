package com.example.Trimble_Cars.controller;

import com.example.Trimble_Cars.model.User;
import com.example.Trimble_Cars.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

        @PostMapping
        public User addUser(@RequestBody User user){
         return userService.addUser(user);
    }
}
