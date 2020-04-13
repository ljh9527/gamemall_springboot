package com.gamemall.gamemall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "game")
public class Game {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    private String gameName;

    private String gameIntroduction;

    private String gameAbout;

    private Integer gamePrice;

    private Integer issuedstatu;
    private String subtitle;
    private Long posterImage;

    public Game() {
    }

    public Game(String gameName, String gameIntroduction, String gameAbout, Integer gamePrice, Long posterImage) {
        this.gameName = gameName;
        this.gameIntroduction = gameIntroduction;
        this.gameAbout = gameAbout;
        this.gamePrice = gamePrice;
        this.posterImage = posterImage;
    }

    public Game(String gameName, String gameIntroduction, String gameAbout, Integer gamePrice, Integer issuedstatu, String subtitle, Long posterImage) {
        this.gameName = gameName;
        this.gameIntroduction = gameIntroduction;
        this.gameAbout = gameAbout;
        this.gamePrice = gamePrice;
        this.issuedstatu = issuedstatu;
        this.subtitle = subtitle;
        this.posterImage = posterImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameIntroduction() {
        return gameIntroduction;
    }

    public void setGameIntroduction(String gameIntroduction) {
        this.gameIntroduction = gameIntroduction;
    }

    public String getGameAbout() {
        return gameAbout;
    }

    public void setGameAbout(String gameAbout) {
        this.gameAbout = gameAbout;
    }

    public Integer getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(Integer gamePrice) {
        this.gamePrice = gamePrice;
    }

    public Long getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(Long posterImage) {
        this.posterImage = posterImage;
    }
}
