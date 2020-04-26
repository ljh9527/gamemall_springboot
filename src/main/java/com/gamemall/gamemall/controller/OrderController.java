package com.gamemall.gamemall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.service.OrderService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public @ResponseBody
    AjaxResponse addOrder(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String out_trade_no = jsonNode.path("out_trade_no").textValue();
        String total_amount = jsonNode.path("total_amount").textValue();
        JSONArray gameid = JSON.parseArray(jsonNode.path("gameid").toString());
        String email = jsonNode.path("email").textValue();
        if(gameid.size() > 0){
            for(int i = 0; i < gameid.size(); i++){
                orderService.addOrder(out_trade_no,total_amount,Long.parseLong(gameid.get(i).toString()),email);
            }
        }
        return AjaxResponse.success("订单添加成功");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public @ResponseBody
    AjaxResponse getOrderList(@RequestParam(required = true, defaultValue = "") String email) throws Exception {
        return AjaxResponse.success(orderService.findByEmail(email));
    }
}
