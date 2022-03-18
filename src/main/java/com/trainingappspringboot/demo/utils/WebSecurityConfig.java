package com.trainingappspringboot.demo.utils;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic(); //browser alert for login
                .antMatchers("/**").access("permitAll") //anyone can see
                .and().cors().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and(); //fixes CORS errors
    }
}
