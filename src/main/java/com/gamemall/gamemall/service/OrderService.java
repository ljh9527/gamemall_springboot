package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Order;
import com.gamemall.gamemall.repositoy.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private OrderRepository OrderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.OrderRepository = orderRepository;
    }

    public Order addOrder(String out_trade_no, String total_amount, Long gameid, String email){
        Order order = new Order();
        order.setEmail(email);
        order.setGameid(gameid);
        order.setOut_trade_no(out_trade_no);
        order.setTotal_amount(total_amount);
        return OrderRepository.saveAndFlush(order);
    }

    public List<Map<String, Object>> findByEmail(String email ){
        return OrderRepository.findByEmail(email);
    }

}
