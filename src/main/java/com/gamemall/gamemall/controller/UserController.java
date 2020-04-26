package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.service.EmailService;
import com.gamemall.gamemall.utils.AjaxResponse;
import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private EmailService emailService;

    @Autowired
    public UserController(UserService userService,EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
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

        User user = userService.getAccount(email, password);
        if(user!=null) {
//            Image image =  imageService.findById(user.getAvatar());
//            UserImage userImage = new UserImage(user.getId(),user.getEmail(),user.getNickname(),user.getIntroduction(),image.getUrl());

            return AjaxResponse.success(user);
        }else{
            return AjaxResponse.error();
        }
    }
//
//    @RequestMapping(method = RequestMethod.POST, path = "/update")
//    public @ResponseBody
//    AjaxResponse loginOut(@RequestBody JsonNode jsonNode) throws Exception {
//        String email = jsonNode.path("email").textValue();
//        String nickname = jsonNode.path("nickname").textValue();
//        userService.updateUserInfo(email,nickname);
//        return AjaxResponse.success();
//    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public @ResponseBody
    AjaxResponse register(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();
        String nickname = jsonNode.path("nickname").textValue();
        String password = jsonNode.path("password").textValue();
        userService.addUser(email,nickname,password);
        return AjaxResponse.success();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/isHasUser")
    public @ResponseBody
    AjaxResponse isHasUser(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();

        boolean hasUser = userService.hasUser(email);
        if(hasUser) {
            return AjaxResponse.error("用户已存在");
        }else{
            return AjaxResponse.success();
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/resetPassword")
        public @ResponseBody
        AjaxResponse resetPassword(@RequestBody JsonNode jsonNode) throws Exception {
            String email = jsonNode.path("email").textValue();
            String password = jsonNode.path("password").textValue();
            userService.resetUserPassword(email,password);
            return AjaxResponse.success();
    }

    // 获取验证码
    @RequestMapping(method = RequestMethod.POST, path = "/verificationCode")
    public @ResponseBody
    AjaxResponse getCode(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        emailService.sendEmail(email);
        return AjaxResponse.success();
    }

    // 校验验证码
    @RequestMapping(method = RequestMethod.POST, path = "/checkCode")
    public @ResponseBody
    AjaxResponse checkCode(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String code = jsonNode.path("code").textValue();
        if(emailService.checkCode(email,code)){
            return AjaxResponse.success();
        } else {
            return AjaxResponse.error();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info")
    public @ResponseBody
    AjaxResponse getUserInfo(@RequestParam(required = false, defaultValue = "") String email) throws Exception {
        User user = userService.getAccount(email);
//        Image image =  imageService.findById(user.getAvatar());
//        UserImage userImage = new UserImage(user.getId(),user.getEmail(),user.getNickname(),user.getIntroduction(),user.getPlaytime(),user.getLastTime(),image.getUrl());
        return AjaxResponse.success(user);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public @ResponseBody
    AjaxResponse updateUserInfo(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String nickname = jsonNode.path("nickname").textValue();
        String introduction = jsonNode.path("introduction").textValue();
        String avater = jsonNode.path("avater").textValue();
        String time = jsonNode.path("time").toString();
        String playtime = jsonNode.path("playtime").textValue();
        if(time == null ||"".equals(time)){
            userService.updateUserInfo(email,nickname,introduction,avater);
        }else{
            Long lastTime = Long.parseLong(time);
            userService.updateUserInfo(email,lastTime,playtime);
        }
        return AjaxResponse.success();
    }
}