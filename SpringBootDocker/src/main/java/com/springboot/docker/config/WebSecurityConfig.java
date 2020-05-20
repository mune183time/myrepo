package com.springboot.docker.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/images/**",
                "/css/**",
                "/javascript/**",
                "/webjars/**");
    }

    //    @Override
    //    public void configure(HttpSecurity http) throws Exception {
    //        http.oauth2Login().and().authorizeRequests().antMatchers("/user/rd").authenticated()
    //                .anyRequest().permitAll().and()
    //                .csrf()
    //                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    //
    //    }
}
