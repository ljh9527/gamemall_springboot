package com.gamemall.gamemall.entity;

public class UserImage {
    private Integer id;
    private String email;
    private String nickname;
    private String avatar;
    private String introduction;


    public UserImage() {
    }

    public UserImage(Integer id, String email, String nickname, String avatar, String introduction) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.avatar = avatar;
        this.introduction = introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
