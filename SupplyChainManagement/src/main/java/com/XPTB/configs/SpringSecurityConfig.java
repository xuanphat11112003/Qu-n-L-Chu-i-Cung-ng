/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.configs;

import com.XPTB.service.UserService;
import com.XPTB.service.impl.UserServiceImpl;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ADMIN
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.XPTB.controller",
    "com.XPTB.repository",
    "com.XPTB.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.formLogin().usernameParameter("username").passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");

        http.logout().logoutSuccessUrl("/login");

//        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
//        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/user/**").access("hasRole('ROLE_ADMIN')");
//        http.authorizeRequests().antMatchers(HttpMethod.GET,"/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')");
//        http.authorizeRequests().antMatchers("/api/**").permitAll()
//                .antMatchers("/**").access("hasRole('ROLE_ADMIN')");

//        http.authorizeRequests().antMatchers("/api/**").permitAll()
//                .antMatchers("/**").hasRole("ADMIN");
        http.csrf().disable();
    }
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dsrf9kurf",
                        "api_key", "719791144812691",
                        "api_secret", "MhOUS2bRoOYyfrQCZFlerjJGpWA",
                        "secure", true));
        return cloudinary;
    }

}
