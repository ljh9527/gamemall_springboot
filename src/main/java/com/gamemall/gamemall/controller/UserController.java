package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity login(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();
        String password = jsonNode.path("password").textValue();
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getAccount(email,password));
    }

    @GetMapping("/hello")
    ResponseEntity hello() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Your age is " );
    }

//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(method = RequestMethod.POST, path = "/register")
//    @ResponseBody
//    public ResponseEntity addUser(@RequestBody JsonNode jsonNode,
//                               @RequestParam(required = false) String select) {
////        EnsureLabUtil.ensureSMPermission();
//        User user;
//        try {
//            user = new ObjectMapper().readValue(jsonNode.traverse(), User.class);
//        } catch (IOException e) {
////            throw new ArgumentErrorException("请查看请求体");
//        }
//        userService.addUser(user);
//        if (select != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(new ObjectSelector().mapObject(userRole, select));
//        }
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//    }
}
