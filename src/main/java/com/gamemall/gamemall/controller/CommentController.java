package com.gamemall.gamemall.controller;

import com.gamemall.gamemall.service.CommentService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
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
}
