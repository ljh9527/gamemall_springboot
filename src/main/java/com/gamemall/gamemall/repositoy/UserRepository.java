package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndAndPassword(String email ,String password);
}
