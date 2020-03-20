package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.UserRepository = userRepository;
    }

    public User getAccount(String email, String password) {
        User user= (User) UserRepository.findByEmailAndAndPassword(email,password);
        return user;
    }
}
