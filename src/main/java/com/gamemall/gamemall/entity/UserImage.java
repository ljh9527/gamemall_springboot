package com.gamemall.gamemall.entity;

import lombok.Data;

@Data
public class UserImage {
    private Integer id;
    private String email;
    private String nickname;
    private String avatar;
    private String introduction;

    public UserImage() {
    }

    public UserImage(Integer id, String email, String nickname, String introduction, String avatar) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.avatar = avatar;
        this.introduction = introduction;
    }
}
