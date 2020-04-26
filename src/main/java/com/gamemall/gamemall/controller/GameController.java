package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.service.GameService;
import com.gamemall.gamemall.service.UserService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/game")
public class GameController {
    private UserService userService;
    private GameService gameService;

    @Autowired
    public GameController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
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

    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public @ResponseBody
    AjaxResponse getGameList(@RequestParam(required = true, defaultValue = "") Long type) throws Exception {

        return AjaxResponse.success(gameService.findIndexGame(type));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info")
    public @ResponseBody
    AjaxResponse getGameInfo(@RequestParam(required = true, defaultValue = "") Long id) throws Exception {

        return AjaxResponse.success(gameService.findGameInfo(id));
    }
}
