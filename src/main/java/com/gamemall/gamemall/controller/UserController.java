package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.entity.AjaxResponse;
import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.service.UserService;
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

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
            return AjaxResponse.success(user);
        }else{
            return AjaxResponse.error();
        }
    }

    @GetMapping("/hello")
    ResponseEntity hello() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Your age is ");
    }
}