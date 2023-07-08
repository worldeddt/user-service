package com.example.netflixzuuluser.infra;


import com.example.netflixzuuluser.entity.GroupEntity;
import com.example.netflixzuuluser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Integer> { }
