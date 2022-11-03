package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> listUser() {
        List<User> users = userService.listUser();
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        user = userService.createUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
