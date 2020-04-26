package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CartRepository  extends JpaRepository<Cart, Integer> {
    Cart findByEmailAndGameid(String email ,Long gameid);

    @Query(nativeQuery = true, value = " SELECT game.id,game.subtitle,game.game_name,game.issueddate,game.game_price,game_image.banner_img FROM game_image RIGHT JOIN game ON game.id = game_image.game_id" +
            " RIGHT JOIN cart ON cart.gameid = game.id WHERE cart.email = :email")
    List<Map<String, Object>> findByEmail(String email);

    void deleteCartByEmailAndGameid(String email ,Long gameid);
}
