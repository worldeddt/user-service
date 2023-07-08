package com.example.netflixzuuluser.controller;


import com.example.netflixzuuluser.dto.UserDto;
import com.example.netflixzuuluser.entity.UserEntity;
import com.example.netflixzuuluser.service.UserServiceImpl;
import com.example.netflixzuuluser.vo.RequestUser;
import com.example.netflixzuuluser.vo.ResponseUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/v1")
@Slf4j
@AllArgsConstructor
public class UserController {
    private UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        this.userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/test")
    public String hi() {
        return "user service";
    }

    @GetMapping("/message")
    public String messages(@RequestHeader("user-request") String header) {
        log.info(header);
        return "header user service";
    }

    @GetMapping("/check")
    public String check(@RequestHeader("user-request") String header) {
        log.info(header);
        return "user service was checked";
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<UserEntity> userList = this.userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        userList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseUser.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId) {
        UserDto userDto = this.userService.getUserByUserId(userId);

        ResponseUser returnValue = new ModelMapper().map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
}
