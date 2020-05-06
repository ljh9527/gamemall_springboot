package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(nativeQuery = true, value = " SELECT game.game_name,game.game_price,game.subtitle,game.issueddate,gameorder.out_trade_no,gameorder.total_amount,gameorder.gameid,game_image.banner_img FROM game_image RIGHT JOIN game ON  game.id = game_image.game_id" +
            " RIGHT JOIN gameorder ON gameorder.gameid = game.id WHERE gameorder.email = :email")
    List<Map<String, Object>> findByEmail(@Param(value = "email") String email);
}
