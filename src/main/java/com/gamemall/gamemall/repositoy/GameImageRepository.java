package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.GameImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GameImageRepository extends JpaRepository<GameImage, Long>, JpaSpecificationExecutor<GameImage> {
    GameImage findGameImageByGameId(Long gameId);
}
