package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.Comment;
import com.gamemall.gamemall.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
//    @Query(value = "select new map(t1,t2) from  Comment t1 left  join User t2 on t2.email=t1.email where t1.gameid =:id")
//    List<Map<String, Object>> findCommentsByGameid(Integer id);

    @Query(nativeQuery = true, value = " SELECT comment.id,comment.content,comment.commentdate,comment.gameid,comment.recommendstatu,user.nickname,user.avatar FROM user" +
            " RIGHT JOIN comment ON comment.email = user.email WHERE comment.gameid = :game_id")
    List<Map<String, Object>> findImagesByGameId(@Param(value = "game_id") Integer gameId);

    Comment findCommentsByEmailAndGameid(String email,Integer gameid);

}
