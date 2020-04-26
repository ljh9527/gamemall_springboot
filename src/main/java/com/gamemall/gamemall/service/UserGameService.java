package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.UserGame;
import com.gamemall.gamemall.repositoy.UserGameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Map<String, Object>> findUserGameByEmailAndStatus(String name,Long status) {
        List<Map<String, Object>> userGame = UserGameRepository.findUserGameByEmailAndStatus(name,status);
        return userGame;
    }

    public UserGame findUserGameByEmailAndGameid(String name,Long gameid) {
        UserGame userGame = UserGameRepository.findUserGameByEmailAndGameid(name,gameid);
        return userGame;
    }

    public UserGame addUserGame(String email,Long gameid,Long status) {
        UserGame userGame = new UserGame();
        userGame.setEmail(email);
        userGame.setGameid(gameid);
        userGame.setStatus(status);
        log.info("userGame"+userGame);
        return UserGameRepository.saveAndFlush(userGame);
    }

    public UserGame updateTime(String email, Long gameid, Date time) {
        UserGame userGame = findUserGameByEmailAndGameid(email,gameid);
        userGame.setLastplay(time);
        log.info("userGame"+userGame);
        return UserGameRepository.saveAndFlush(userGame);
    }

}
