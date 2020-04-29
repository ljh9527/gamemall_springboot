package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.entity.UserGame;
import com.gamemall.gamemall.service.EmailService;
import com.gamemall.gamemall.service.UserGameService;
import com.gamemall.gamemall.service.UserService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/usergame")
public class UserGameController {

    private UserGameService userGameService;
    @Autowired
    public UserGameController(UserGameService userGameService) {
        this.userGameService = userGameService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mygame")
    public @ResponseBody
    AjaxResponse getUserGame(@RequestParam(required = false, defaultValue = "") String email, Long status) throws Exception {
//        userGameService.findUserGameByEmail(email);
        return AjaxResponse.success(userGameService.findUserGameByEmailAndStatus(email,status));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mygame/detail")
    public @ResponseBody
    AjaxResponse getUserGameByEmailAndGameid(@RequestParam(required = false, defaultValue = "") String email, Long gameid) throws Exception {
        return AjaxResponse.success(userGameService.findUserGameByEmailAndGameid(email,gameid));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/game/add")
    public @ResponseBody
    AjaxResponse addMyGame(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").textValue();
        String status = jsonNode.path("status").textValue();
        UserGame userGame = userGameService.findUserGameByEmailAndGameid(email,Long.parseLong(gameid));
        log.info("gameid"+userGame);
        if(userGame == null){
            userGameService.addUserGame(email,Long.parseLong(gameid),Long.parseLong(status));
            return AjaxResponse.success();
        }else{
            return AjaxResponse.error();
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateTime")
    public @ResponseBody
    AjaxResponse updateTime(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").toString();
        Date time = new Date();
        UserGame userGame = userGameService.updateTime(email,Long.parseLong(gameid),time);
        log.info("gameid"+userGame);
        if(userGame == null){
            return AjaxResponse.error();
        }else{
            return AjaxResponse.success();
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateStatus")
    public @ResponseBody
    AjaxResponse updateStatus(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").toString();
        String status = jsonNode.path("status").textValue();
        UserGame userGame = userGameService.updateStatus(email,Long.parseLong(gameid),Long.parseLong(status));
        log.info("gameid"+userGame);
        if(userGame == null){
            return AjaxResponse.error();
        }else{
            return AjaxResponse.success();
        }
    }

}
