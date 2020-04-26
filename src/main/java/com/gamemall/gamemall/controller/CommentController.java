package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.service.CommentService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comment")
public class
CommentController {
    private CommentService CommentService;

    @Autowired
    public CommentController(CommentService CommentService) {
        this.CommentService = CommentService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/game")
    public @ResponseBody
    AjaxResponse getGameComment(@RequestParam(required = true, defaultValue = "") Integer id) throws Exception {
        log.info("info"+CommentService.findGameComment(id));
        return AjaxResponse.success(CommentService.findGameComment(id));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public @ResponseBody
    AjaxResponse getUserGameComment(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").textValue();
        log.info("info"+CommentService.findUserGameComment(email,Integer.parseInt(gameid)));
        return AjaxResponse.success(CommentService.findUserGameComment(email,Integer.parseInt(gameid)));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    public @ResponseBody
    AjaxResponse deleteUserGameComment(@RequestBody JsonNode jsonNode) throws Exception {
        String id = jsonNode.path("id").toString();
        log.info("info"+id);
        CommentService.deleteUserGameComment(Integer.parseInt(id));
        return AjaxResponse.success();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public @ResponseBody
    AjaxResponse addUserGameComment(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").textValue();
        String content = jsonNode.path("content").textValue();
        String recommendstatu = jsonNode.path("recommendstatu").toString();
//        String commentdate = jsonNode.path("commentdate").toString();
        CommentService.addUserGameComment(email,Integer.parseInt(gameid),content,Long.parseLong(recommendstatu));
        return AjaxResponse.success();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/append")
    public @ResponseBody
    AjaxResponse appendUserGameComment(@RequestBody JsonNode jsonNode) throws Exception {
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").textValue();
        String appendcontent = jsonNode.path("appendcontent").textValue();
        CommentService.addUserGameAppendComment(email,Integer.parseInt(gameid),appendcontent);
        return AjaxResponse.success();
    }

}
