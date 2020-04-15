package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, Integer> {
    Code findByEmail(String email);
}
