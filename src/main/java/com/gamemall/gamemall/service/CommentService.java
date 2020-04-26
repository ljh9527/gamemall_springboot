package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Comment;
import com.gamemall.gamemall.entity.Image;
import com.gamemall.gamemall.repositoy.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Comment findUserGameComment(String email,Integer id) {

        Comment comment = CommentRepository.findCommentsByEmailAndGameid(email,id);
        return comment;
    }

    public void deleteUserGameComment(Integer id) {

        CommentRepository.deleteById(id);
        return ;
    }

    public void addUserGameComment(String email,Integer gameid,String content,Long recommendstatu) {
        Date commentdate = new Date();
        Comment comment = new Comment();
        comment.setEmail(email);
        comment.setGameid(gameid);
        comment.setContent(content);
        comment.setRecommendstatu(recommendstatu);
        comment.setCommentdate(commentdate);
        CommentRepository.saveAndFlush(comment);
        return ;
    }

    public void addUserGameAppendComment(String email,Integer gameid,String appendcontent) {
        Date appenddate = new Date();
        Comment comment = CommentRepository.findCommentsByEmailAndGameid(email,gameid);
        comment.setAppendcontent(appendcontent);
        comment.setAppenddate(appenddate);
        CommentRepository.saveAndFlush(comment);
        return ;
    }
}
