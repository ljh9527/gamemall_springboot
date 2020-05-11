package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.GameIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface GameIndexRepository extends JpaRepository<GameIndex, Long>, JpaSpecificationExecutor<GameIndex> {

    @Query(nativeQuery = true, value = " SELECT game.game_name,game.subtitle,game.issueddate,game.game_price,gameindex.show_type,gameindex.game_id,gameindex.id,game_image.banner_img  FROM game_image RIGHT JOIN game ON game.id = game_image.game_id" +
            " RIGHT JOIN gameindex ON gameindex.game_id = game.id WHERE gameindex.show_type = :showType")
    List<Map<String, Object>> findByShowType(Long showType);

    List<GameIndex> findGameIndexesByShowType(Long showType);

    GameIndex findGameIndexByGameId(Long id);
}
