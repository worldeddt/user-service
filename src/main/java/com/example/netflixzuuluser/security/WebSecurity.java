//package com.example.netflixzuuluser.security;
//
//
//import com.example.netflixzuuluser.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class WebSecurity {
//
//    private UserService userService;
//    private AuthenticationManager authenticationManager;
//    private Environment env;
//
//    private static final String[] AUTH_WHITELIST = {
//            "/", "/user/**", "/actuator/**"
//    };
//
//    @Bean
//    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsService);
////        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
//
//        http.csrf().disable();
//        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers(AUTH_WHITELIST)
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .shouldFilterAllDispatcherTypes(false)
//        );
//
//        http.formLogin()
//            .loginPage("/user/login")
//                .loginProcessingUrl("/user/loginProcess")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .successForwardUrl("/user/login/success")
//                .failureForwardUrl("/user/login/fail");
//
//        return http.build();
//    }
//}
