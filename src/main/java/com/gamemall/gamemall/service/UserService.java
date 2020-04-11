package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.repositoy.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.UserRepository = userRepository;
    }

    public User getAccount(String email, String password) {
        User user = (User) UserRepository.findByEmailAndAndPassword(email, password);
        return user;
    }

    public User getAccount(String email) {
        User user = (User) UserRepository.findByEmail(email);
        return user;
    }

    public User addUser(String email, String nickname, String password) {
        User user = new User();
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(password);
        return UserRepository.saveAndFlush(user);
    }

    public User resetUserPassword(String email, String password) {
        User user = UserRepository.findByEmail(email);
        user.setPassword(password);
        log.info("user:"+user);
        return UserRepository.saveAndFlush(user);
    }

    public boolean hasUser(String email) {
        User userName = UserRepository.findByEmail(email);
        return userName == null ? false:true;
    }
}
