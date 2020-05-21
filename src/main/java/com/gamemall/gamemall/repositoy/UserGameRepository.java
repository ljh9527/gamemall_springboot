package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserGameRepository  extends JpaRepository<UserGame, Integer>, JpaSpecificationExecutor<UserGame> {

    @Query(nativeQuery = true, value = " SELECT user_game.playtime,user_game.lastplay,game.id,game.download,game.game_name,game_image.image_cover FROM game_image RIGHT JOIN game ON  game.id = game_image.game_id" +
            " RIGHT JOIN user_game ON user_game.gameid = game.id WHERE user_game.email = :email AND user_game.status = :status")
    List<Map<String, Object>> findUserGameByEmailAndStatus(@Param("email") String email,@Param("status") Long status);

    UserGame findUserGameByEmailAndGameid(String email,Long id);
}
