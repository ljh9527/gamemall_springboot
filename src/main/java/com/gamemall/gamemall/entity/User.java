package com.gamemall.gamemall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    @Size(max = 40, message = "邮件长度不能超过40")
    @Column(name = "email", unique = true)
    @JsonProperty("email")
    private String email;

    @Column(name = "nickname", length = 50)
    @Size(max = 50, message = "昵称长度不能超过50")
    @JsonProperty("nickname")
    private String nickname;

    @Column(name = "password", length = 200)
    @Size(max = 200, message = "用户密码长度不能超过200")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "avatar", length = 2000)
    @JsonProperty("avatar")
    private String avatar;

    @Column(name = "salt", length = 50)
    @Size(max = 50, message = "加密盐长度不能超过50")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;

    private String introduction;

    private Double playtime;

    private Long lastTime;

    private Integer isadmin;

    public Double getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Double playtime) {
        this.playtime = playtime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
