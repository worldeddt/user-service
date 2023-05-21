package com.example.netflixzuuluser.infra;


import com.example.netflixzuuluser.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUserId(String userId);
    UserEntity findByEmail(String username);
}
