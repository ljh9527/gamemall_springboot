package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Game;
import com.gamemall.gamemall.repositoy.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {

        List<Game> game = gameRepository.findAll();
        return game;
    }

    public List<Map<String, Object>> findGamesByRecommend(String type) {

        List<Map<String, Object>> game = gameRepository.findGamesByRecommend(type);
        return game;
    }
    public List<Map<String, Object>> findGamesBySellwell(String type) {
        List<Map<String, Object>> game = gameRepository.findGamesBySellwell(type);
        return game;
    }
    public List<Map<String, Object>> findGamesByPrepurchase(String type) {
        List<Map<String, Object>> game = gameRepository.findGamesByPrepurchase(type);
        return game;
    }
    public List<Map<String, Object>> findGamesByMasterpiece(String type) {
        List<Map<String, Object>> game = gameRepository.findGamesByMasterpiece(type);
        return game;
    }
    public List<Map<String, Object>> findGamesBySingle(String type) {
        List<Map<String, Object>> game = gameRepository.findGamesBySingle(type);
        return game;
    }

    public List<Map<String, Object>> findGameByName(String name) {
        List<Map<String, Object>> game = gameRepository.findGameByName(name);
        return game;
    }

    public List<Map<String, Object>> findIndexGame(Long type) {

        List<Map<String, Object>> game = gameRepository.findGameAndGameIndexByHQL(type);
        return game;
    }

    public List<Map<String, Object>> findGameInfo(Long id) {

        List<Map<String, Object>> gameinfo = gameRepository.findGameAndGameImageByHQL(id);
        log.info("game"+gameinfo);
        return gameinfo;
    }
}
