package com.example.netflixzuuluser.infra;


import com.example.netflixzuuluser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserId(String userId);
    UserEntity findByEmail(String username);
}
