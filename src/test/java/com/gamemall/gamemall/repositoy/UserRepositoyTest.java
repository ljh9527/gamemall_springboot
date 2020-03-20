package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoyTest {

    @Autowired
    private UserRepository UserRepository;

    @Test
    void  findAll(){
        System.out.println(UserRepository.findAll());
    }

}