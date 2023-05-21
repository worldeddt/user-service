package com.example.netflixzuuluser.security;


import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.management.ConstructorParameters;


@Configuration
@EnableWebSecurity
public class WebSecurity {
    private static final String[] AUTH_WHITELIST = {
            "/", "/user/**"
    };

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .shouldFilterAllDispatcherTypes(false)
                .requestMatchers(AUTH_WHITELIST)
                .permitAll()
                .anyRequest()
                .authenticated());

        http.csrf().disable();

        http.formLogin()
            .loginPage("/user/login")
                .loginProcessingUrl("/user/loginProcess")
                .usernameParameter("username")
                .passwordParameter("password")
                .successForwardUrl("/user/login/success")
                .failureForwardUrl("/user/login/fail");

        return http.build();
    }
}
