package com.example.netflixzuuluser.security;


import com.example.netflixzuuluser.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurity {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private Environment env;
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

//        AuthenticationFilter authenticationFilter = new AuthenticationFilter(
//                authenticationManager,
//                userService,
//                env
//        );
//        AuthenticationProvider
//        JwtAuthenticationToken

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
