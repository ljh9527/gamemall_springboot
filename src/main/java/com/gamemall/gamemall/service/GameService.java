package com.gamemall.gamemall.service;

import com.alibaba.fastjson.JSONArray;
import com.gamemall.gamemall.entity.Game;
import com.gamemall.gamemall.repositoy.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return gameinfo;
    }

    public Game addGame(String game_name, String subtitle, String developers, String operator, String game_price, String issueddate, String game_introduction, String game_about, JSONArray status) {
        Game game = new Game();

        long lt = new Long(issueddate);
        Date date = new Date(lt);

        if(status.size() > 0){
            for(int i = 0; i < status.size(); i++){
                if(status.get(i).toString().equals("recommend")){
                    game.setRecommend("1");
                }else if(status.get(i).toString().equals("sellWell")){
                    game.setSellwell("1");
                }else if(status.get(i).toString().equals("prePurchase")){
                    game.setPrepurchase("1");
                }else if(status.get(i).toString().equals("masterpiece")){
                    game.setMasterpiece("1");
                }else{
                    game.setSingle("1");
                }
            }
        }
        game.setGameName(game_name);
        game.setSubtitle(subtitle);
        game.setDevelopers(developers);
        game.setOperator(operator);
        game.setGamePrice(Integer.parseInt(game_price));
        game.setIssueddate(date);
        game.setGameIntroduction(game_introduction);
        game.setGameAbout(game_about);
        return gameRepository.saveAndFlush(game);
    }

    public Game updataGameImage(Long gameid,Long imageid){
        Game game = gameRepository.findById(gameid);
        game.setPosterImage(imageid);
        return gameRepository.saveAndFlush(game);
    }
}
