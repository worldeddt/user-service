package com.example.netflixzuuluser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class NetflixZuulUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulUserApplication.class, args);
    }

}
