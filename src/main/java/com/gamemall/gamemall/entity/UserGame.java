package com.gamemall.gamemall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_game")
public class UserGame {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    private String email;
    private Long gameid;
    private Integer playtime;
    private Date lastplay;
}
