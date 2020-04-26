package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Cart;
import com.gamemall.gamemall.repositoy.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@Transactional
@Service
public class CartService {
    private CartRepository CartRepository;
    @Autowired
    public CartService(CartRepository cartRepository) {
        this.CartRepository = cartRepository;
    }

    public Cart addGameCart(String email,Long gameid){
        Cart cart = new Cart();
        cart.setEmail(email);
        cart.setGameid(gameid);
        return CartRepository.saveAndFlush(cart);
    }

    public Cart findByEmailAndGameid(String email,Long gameid){
        return CartRepository.findByEmailAndGameid(email,gameid);
    }

    public List<Map<String, Object>> findByEmail(String email){
        return CartRepository.findByEmail(email);
    }

    public void deleteByEmailAndGameid(String email,Long gameid){
        CartRepository.deleteCartByEmailAndGameid(email,gameid);
        return ;
    }

}
