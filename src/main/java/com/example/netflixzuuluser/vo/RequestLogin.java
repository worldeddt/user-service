package com.example.netflixzuuluser.vo;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestLogin {
    @NotNull(message = "이메일은 필수입니다.")
    @Size(min = 2, message = "최소 2자리 이상입니다.")
    @Email
    private String email;

    @NotNull(message = "비밀번호를 입력해 주세요.")
    @Size(min = 8, message = "최소 8자리 이상입니다.")
    private String password;
}
