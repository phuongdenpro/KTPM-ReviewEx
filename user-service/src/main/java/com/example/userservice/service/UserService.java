package com.example.userservice.service;

import java.util.List;

import com.example.userservice.entity.User;

public interface UserService {
    User createUser(User user);
     List<User> listUser();
     User getUserById(int id);
    boolean deleteUser(int id);

}
