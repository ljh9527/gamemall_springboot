package com.gamemall.gamemall.service;

import com.gamemall.gamemall.repositoy.UserGameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserGameService {
    private UserGameRepository UserGameRepository;

    @Autowired
    public UserGameService(UserGameRepository userGameRepository) {
        this.UserGameRepository = userGameRepository;
    }

    public List<Map<String, Object>> findUserGameByEmail(String name) {
        List<Map<String, Object>> userGame = UserGameRepository.findUserGameByEmail(name);
        return userGame;
    }
}
