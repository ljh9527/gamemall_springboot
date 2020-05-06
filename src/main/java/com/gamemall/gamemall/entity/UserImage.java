package com.gamemall.gamemall.entity;

import lombok.Data;

@Data
public class UserImage {
    private Integer id;
    private String email;
    private String nickname;
    private String avatar;
    private String introduction;
    private Double playtime;
    private Long lastTime;

    public UserImage() {
    }

    public UserImage(Integer id, String email, String nickname, String introduction, String avatar) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.avatar = avatar;
        this.introduction = introduction;
    }

    public UserImage(Integer id, String email, String nickname, String introduction, Double playtime, Long lastTime, String avatar) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.avatar = avatar;
        this.introduction = introduction;
        this.playtime = playtime;
        this.lastTime = lastTime;
    }
}