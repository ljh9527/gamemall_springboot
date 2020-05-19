package com.gamemall.gamemall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "gameindex")
public class GameIndex {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    private Long gameId;

    private Long showType;
//    private String bannerImg;
}
