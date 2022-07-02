package com.softuni.musicapp.config;

import com.softuni.musicapp.service.implementation.MusicDBUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MusicDBUserService musicDBUserService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(MusicDBUserService musicDBUserService, PasswordEncoder passwordEncoder) {
        this.musicDBUserService = musicDBUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/img/**").permitAll()
                .antMatchers("/", "/users/login", "/users/register").permitAll()
                .antMatchers("/**")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/users/login-error");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(musicDBUserService)
                .passwordEncoder(passwordEncoder);
    }
}
