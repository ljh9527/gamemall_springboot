package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.entity.Image;
import com.gamemall.gamemall.entity.UserImage;
import com.gamemall.gamemall.service.ImageService;
import com.gamemall.gamemall.utils.AjaxResponse;
import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.service.UserService;
import com.gamemall.gamemall.utils.ResultMsg;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private ImageService imageService;

    @Autowired
    public UserController(UserService userService,ImageService imageService) {
        this.userService = userService;
        this.imageService = imageService;
    }

    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public @ResponseBody
    AjaxResponse login(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();
        String password = jsonNode.path("password").textValue();

        log.info("user:"+userService.getAccount(email, password));
        User user = userService.getAccount(email, password);
        if(user!=null) {
            Image image =  imageService.findById(user.getAvatar());
            UserImage userImage = new UserImage(user.getId(),user.getEmail(),user.getNickname(),user.getIntroduction(),image.getUrl());
            log.info("image:" + userImage);
            return AjaxResponse.success(userImage);
        }else{
            return AjaxResponse.error();
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public @ResponseBody
    AjaxResponse register(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();
        String nickname = jsonNode.path("nickname").textValue();
        String password = jsonNode.path("password").textValue();
        log.info("jsonNode:"+jsonNode);

        boolean hasUser = userService.hasUser(email);
        log.info("user:"+hasUser);
        if(hasUser) {
            return AjaxResponse.error("用户已存在");
        }else{
            userService.addUser(email,nickname,password);
            return AjaxResponse.success();
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/resetPassword")
    public @ResponseBody
    AjaxResponse resetPassword(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();
        String password = jsonNode.path("password").textValue();
        boolean hasUser = userService.hasUser(email);
        log.info("user:"+hasUser);
        if(hasUser) {
            userService.resetUserPassword(email,password);
            return AjaxResponse.success();
        }else{
            return AjaxResponse.error("用户不存在");
        }
    }
}