package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Image;
import com.gamemall.gamemall.repositoy.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private ImageRepository ImageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.ImageRepository = imageRepository;
    }

    public Image findById(long id) {
        Image image = (Image) ImageRepository.findById(id);
        return image;
    }
}