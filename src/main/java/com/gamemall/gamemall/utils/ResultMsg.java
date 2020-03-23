package com.gamemall.gamemall.utils;

import java.util.Stack;

public class ResultMsg {

    public final static ResultMsg SUCCESS=new ResultMsg("200","成功");

    public final static ResultMsg LOGIN_SUCCESS=new ResultMsg("201","登陆成功");

    public final static ResultMsg REGISTER_SUCCESS=new ResultMsg("202","注册成功");

    public final static ResultMsg SPIKE_SUCCESS=new ResultMsg("203","秒杀成功");

    public final static ResultMsg NO_EMAIL=new ResultMsg("501","该邮箱不存在");

    public final static ResultMsg PASS_ERROR=new ResultMsg("502","密码错误");

    public final static ResultMsg HAD_Login=new ResultMsg("503","已在其他客户端登录");

    public final static ResultMsg HAD_REGISTER=new ResultMsg("504","邮箱已被注册");

    public final static ResultMsg CODE_ERROR=new ResultMsg("505","验证码错误");

    public final static ResultMsg CODE_INVALID=new ResultMsg("506","验证码失效，请重新发送");

    public final static ResultMsg STOCK_IS_NULL=new ResultMsg("507","秒杀游戏库为零");

    public final static ResultMsg NO_LOGIN=new ResultMsg("508","尚未登录");

    public final static ResultMsg NO_GAME=new ResultMsg("509","该游戏未参与秒杀");

    public final static ResultMsg SPIKE_ING=new ResultMsg("510","秒杀中...");

    public final static ResultMsg SPIKE_REPEAT=new ResultMsg("511","不能重复秒杀");

    public final static ResultMsg LABEL_PRESENCE=new ResultMsg("512","标签已存在");

    public final static ResultMsg SPIKE_END=new ResultMsg("513","秒杀结束");

    public final static ResultMsg SPIKE_NO_START=new ResultMsg("514","秒杀尚未开始");

    public final static ResultMsg USER_NO=new ResultMsg("515","用户不存在");

    public final static ResultMsg IMAGE_OVERSIZE=new ResultMsg("516","图片大小超过10M");

    public final static ResultMsg IMAGE_TYPE_ERROR=new ResultMsg("517","图片类型错误");

    public final static ResultMsg SPIKE_LIMIT_ERROR=new ResultMsg("518","秒杀次数过多，请稍后再试");

    public final static ResultMsg SPIKE_PATH_ERROR=new ResultMsg("519","秒杀路径错误");

    public final static ResultMsg GAME_HAD=new ResultMsg("520","游戏购买，不能参与秒杀");

    public final static ResultMsg ADMIN_NO=new ResultMsg("521","该账户不是管理员");

    public final static ResultMsg PASS_NOT_EQUAL=new ResultMsg("522","两次密码不一致");

    private String code;

    private Object msg;

    private ResultMsg(String code,Object msg){
        this.code=code;
        this.msg=msg;
    }

    public static ResultMsg SUCCESS(Object object){
        return new ResultMsg("200",object);
    }

    public static ResultMsg FAILURE(Object object){
        return new ResultMsg("500",object);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
