package com.example.netflixzuuluser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EntityScan("com.example.netflixzuuluser.entity")
@EnableJpaRepositories("com.example.netflixzuuluser.infra")
//@EnableDiscoveryClient
public class NetflixZuulUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulUserApplication.class, args);
    }
}
