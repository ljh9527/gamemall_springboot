package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findById(long id);
}
