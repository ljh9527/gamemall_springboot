package com.gamemall.gamemall.service;

import com.alibaba.fastjson.JSONArray;
import com.gamemall.gamemall.entity.Game;
import com.gamemall.gamemall.entity.GameIndex;
import com.gamemall.gamemall.repositoy.GameIndexRepository;
import com.gamemall.gamemall.repositoy.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GameService {
    private GameRepository gameRepository;
    private GameIndexRepository gameIndexRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public GameService(GameRepository gameRepository,GameIndexRepository gameIndexRepository) {
        this.gameRepository = gameRepository;
        this.gameIndexRepository = gameIndexRepository;
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

//    public List<Map<String, Object>> findIndexGame(Long type) {
//
//        List<Map<String, Object>> game = gameRepository.findGameAndGameIndexByHQL(type);
//        return game;
//    }

    public List<Map<String, Object>> findGameInfo(Long id) {

        List<Map<String, Object>> gameinfo = gameRepository.findGameAndGameImageByHQL(id);
        return gameinfo;
    }

    public Map<String, Object> getGameInfo(Long id) {

        Map<String, Object> gameinfo = gameRepository.findGameById(id);
        return gameinfo;
    }

    public Game addGame(String id, String game_name, String subtitle, String developers, String operator, String game_price, String issueddate, String game_introduction, String game_about, JSONArray status) {
        Game game = gameRepository.findById(Long.parseLong(id));
        if(game == null){
            game = new Game();
        }

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

    public List<Map<String, Object>> findGameList(Long type) {
        List<Map<String, Object>> gameList = gameIndexRepository.findByShowType(type);
        return gameList;
    }

    public List<GameIndex> updateGameIndex(Long type,JSONArray newdate){
        List<GameIndex> gameList = gameIndexRepository.findGameIndexesByShowType(type);
        for(int i = 0; i < gameList.size(); i++){
            gameList.get(i).setGameId(Long.parseLong(newdate.get(i).toString()));
        }
        return gameIndexRepository.saveAll(gameList);
    }

    public List<Map<String, Object>> searchGame(String type,String game_name){
        String sql = "select * from game where 1 = 1";
        log.info("game_name"+game_name);
        if(game_name != null){
            sql = sql + " AND " + "game_name LIKE '%" + game_name + "%'";
        }
        if(type != null){
            sql = sql + " AND " + type + " = 1";
        }
        if(type == null && game_name == null){
            sql = "select * from game";
        }
        Query query = entityManager.createNativeQuery(sql, Game.class);
        List<Map<String, Object>> list = query.getResultList();
        return list;
    }

    public Boolean deleteGame(Long id){
        if(gameIndexRepository.findGameIndexByGameId(id) != null){
            return false;
        } else{
            gameRepository.delete(gameRepository.findById(id));
            return true;
        }
    }

}
