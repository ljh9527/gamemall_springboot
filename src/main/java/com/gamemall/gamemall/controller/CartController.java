package com.gamemall.gamemall.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamemall.gamemall.entity.Cart;
import com.gamemall.gamemall.service.CartService;
import com.gamemall.gamemall.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public @ResponseBody
    AjaxResponse addCart(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").textValue();
        if(cartService.findByEmailAndGameid(email,Long.parseLong(gameid)) != null){
            return AjaxResponse.error("游戏已在购物车");
        }else{
            cartService.addGameCart(email,Long.parseLong(gameid));
            return AjaxResponse.success("添加成功");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public @ResponseBody
    AjaxResponse getUserInfo(@RequestParam(required = false, defaultValue = "") String email) throws Exception {
        return AjaxResponse.success(cartService.findByEmail(email));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    public @ResponseBody
    AjaxResponse deleteCart(@RequestBody JsonNode jsonNode) throws Exception {
        //用户认证
        String email = jsonNode.path("email").textValue();
        String gameid = jsonNode.path("gameid").textValue();
        cartService.deleteByEmailAndGameid(email,Long.parseLong(gameid));
        return AjaxResponse.success("删除成功");
    }
}
