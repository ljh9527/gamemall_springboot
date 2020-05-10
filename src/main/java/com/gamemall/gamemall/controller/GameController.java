package com.gamemall.gamemall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.entity.Game;
import com.gamemall.gamemall.entity.GameImage;
import com.gamemall.gamemall.service.GameImageService;
import com.gamemall.gamemall.service.GameService;
import com.gamemall.gamemall.service.UserService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/game")
public class GameController {
    private UserService userService;
    private GameService gameService;
    private GameImageService gameImageService;

    @Autowired
    public GameController(UserService userService, GameService gameService, GameImageService gameImageService) {
        this.userService = userService;
        this.gameService = gameService;
        this.gameImageService = gameImageService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/listall")

    public @ResponseBody
    AjaxResponse getGameList(@RequestBody JsonNode jsonNode) throws Exception {

        return AjaxResponse.success(gameService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/list")
    public @ResponseBody
    AjaxResponse getGameListType(@RequestBody JsonNode jsonNode) throws Exception {
        String param = jsonNode.path("param").textValue();
        log.info("param"+param);
        String has = "1";
        if(param.equals("recommend")){
            return AjaxResponse.success(gameService.findGamesByRecommend(has));
        }else if(param.equals("sellWell")){
            return AjaxResponse.success(gameService.findGamesBySellwell(has));
        }else if(param.equals("prePurchase")){
            return AjaxResponse.success(gameService.findGamesByPrepurchase(has));
        }else if(param.equals("masterpiece")){
            return AjaxResponse.success(gameService.findGamesByMasterpiece(has));
        }else if(param.equals("single")){
            return AjaxResponse.success(gameService.findGamesBySingle(has));
        }else{
            return AjaxResponse.success(gameService.findAll());
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/name")
    public @ResponseBody
    AjaxResponse getSearchGame(@RequestBody JsonNode jsonNode) throws Exception {
        String name = jsonNode.path("name").textValue();
        return AjaxResponse.success(gameService.findGameByName(name));
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/index")
//    public @ResponseBody
//    AjaxResponse getGameList(@RequestParam(required = true, defaultValue = "") Long type) throws Exception {
//
//        return AjaxResponse.success(gameService.findIndexGame(type));
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/info")
    public @ResponseBody
    AjaxResponse getGameInfo(@RequestParam(required = true, defaultValue = "") Long id) throws Exception {

        return AjaxResponse.success(gameService.findGameInfo(id));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public @ResponseBody
    AjaxResponse addGame(@RequestBody JsonNode jsonNode) throws Exception {
        String game_name = jsonNode.path("game_name").textValue();
        String subtitle = jsonNode.path("subtitle").textValue();
        String developers = jsonNode.path("developers").textValue();
        String operator = jsonNode.path("operator").textValue();
        String game_price = jsonNode.path("game_price").textValue();
        String issueddate = jsonNode.path("issueddate").textValue();
        String game_introduction = jsonNode.path("game_introduction").textValue();
        String game_about = jsonNode.path("game_about").textValue();
        JSONArray status = JSON.parseArray(jsonNode.path("status").toString());
        String image_cover = jsonNode.path("image_cover").textValue();
        String banner_img = jsonNode.path("banner_img").textValue();
        String image1 = jsonNode.path("image1").textValue();
        String image2 = jsonNode.path("image2").textValue();
        String image3 = jsonNode.path("image3").textValue();
        String image4 = jsonNode.path("image4").textValue();
        String image5 = jsonNode.path("image5").textValue();
        String image6 = jsonNode.path("image6").textValue();

        Game game = gameService.addGame(game_name,subtitle,developers,operator,game_price,issueddate,game_introduction,game_about,status);
        GameImage gameimage =  gameImageService.addGameImage(game.getId(),image_cover,banner_img,image1,image2,image3,image4,image5,image6);
        gameService.updataGameImage(game.getId(),gameimage.getId());
        return AjaxResponse.success();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/index/type")
    public @ResponseBody
    AjaxResponse getGameIndexList(@RequestParam(required = true, defaultValue = "") Long type) throws Exception {

        return AjaxResponse.success(gameService.findGameList(type));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/index/update")
    public @ResponseBody
    AjaxResponse updateGameIndex(@RequestBody JsonNode jsonNode) throws Exception {
        Long type = jsonNode.path("type").longValue();
        JSONArray indexData = JSON.parseArray(jsonNode.path("value").toString());
        return AjaxResponse.success(gameService.updateGameIndex(type,indexData));
    }
}
