package com.example.netflixzuuluser;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/create")
    public String register() {
        return "register";
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

    @GetMapping("/customCheck")
    public String customCheck(String header) {
        return "user custom check";
    }
}
