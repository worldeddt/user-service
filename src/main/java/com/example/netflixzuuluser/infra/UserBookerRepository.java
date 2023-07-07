package com.example.netflixzuuluser.infra;

import com.example.netflixzuuluser.entity.UsersBooker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.module.FindException;

@Repository
public interface UserBookerRepository extends JpaRepository<UsersBooker, Integer> {
}
