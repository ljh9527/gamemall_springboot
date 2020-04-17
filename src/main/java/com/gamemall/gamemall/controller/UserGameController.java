package com.gamemall.gamemall.controller;

import com.gamemall.gamemall.service.EmailService;
import com.gamemall.gamemall.service.UserGameService;
import com.gamemall.gamemall.service.UserService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    AjaxResponse getUserGame(@RequestParam(required = false, defaultValue = "") String email) throws Exception {
//        userGameService.findUserGameByEmail(email);
        return AjaxResponse.success(userGameService.findUserGameByEmail(email));
    }
}
