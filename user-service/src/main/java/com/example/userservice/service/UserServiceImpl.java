package com.example.userservice.service;

import java.util.List;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUser() {
        List<User> products = (List<User>) userRepository.findAll();
        return products;
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}