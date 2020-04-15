package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Comment;
import com.gamemall.gamemall.entity.Image;
import com.gamemall.gamemall.repositoy.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CommentService {
    private CommentRepository CommentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.CommentRepository = commentRepository;
    }

    public List<Map<String, Object>> findGameComment(Integer id) {

        List<Map<String, Object>> comment = CommentRepository.findImagesByGameId (id);
        return comment;
    }
}
