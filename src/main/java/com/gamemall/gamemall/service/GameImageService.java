package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Game;
import com.gamemall.gamemall.entity.GameImage;
import com.gamemall.gamemall.repositoy.GameImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GameImageService {
    private GameImageRepository gameImageRepository;
    @Autowired
    public GameImageService(GameImageRepository gameImageRepository) {
        this.gameImageRepository = gameImageRepository;
    }

    public GameImage addGameImage(Long gameId, String image_cover, String banner_img, String image1, String image2, String image3, String image4, String image5, String image6) {
        GameImage gameImage = gameImageRepository.findGameImageByGameId(gameId);
        if(gameImage == null){
            gameImage = new GameImage();
        }
        gameImage.setGameId(gameId);
        gameImage.setImageCover(image_cover);
        gameImage.setBannerImg(banner_img);
        gameImage.setImage1(image1);
        gameImage.setImage2(image2);
        gameImage.setImage3(image3);
        gameImage.setImage4(image4);
        gameImage.setImage5(image5);
        gameImage.setImage6(image6);

        return gameImageRepository.saveAndFlush(gameImage);
    }
}
