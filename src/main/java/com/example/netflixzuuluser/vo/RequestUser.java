package com.example.netflixzuuluser.vo;


import lombok.Data;

@Data
public class RequestUser {
    public String email;
    public String name;
    public String userId;
    public String encryptedPwd;
}
