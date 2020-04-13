package com.gamemall.gamemall.controller;

import com.gamemall.gamemall.entity.Image;
import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.entity.UserImage;
import com.gamemall.gamemall.service.EmailService;
import com.gamemall.gamemall.service.GameService;
import com.gamemall.gamemall.service.ImageService;
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

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public @ResponseBody
    AjaxResponse getGameList() throws Exception {
        log.info("info"+gameService.findAll());
        return AjaxResponse.success(gameService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public @ResponseBody
    AjaxResponse getGameList(@RequestParam(required = true, defaultValue = "") Long type) throws Exception {
        log.info("info"+gameService.findIndexGame(type));
        return AjaxResponse.success(gameService.findIndexGame(type));
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/info")
//    public @ResponseBody
//    AjaxResponse getGameInfo(@RequestParam(required = true, defaultValue = "") Long id) throws Exception {
//        log.info("info"+gameService.findGameInfo(id));
//        return AjaxResponse.success(gameService.findGameInfo(id));
//    }
}
