package com.example.basic_auth_issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private/*")
                .authenticated().and().httpBasic()
                .and().csrf().disable();
    }

// TODO: uncomment to see the applicsation without the issue
//    @Autowired
//    @SuppressWarnings("deprecation")
//    public void configureGlobal(AuthenticationManagerBuilder auth, SecurityProperties properties) throws Exception {
//        PasswordEncoder passwordEncoder = new MessageDigestPasswordEncoder("SHA-256");
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
//                .withUser(properties.getUser().getName())
//                .password(passwordEncoder.encode(properties.getUser().getPassword()))
//                .roles("SERVICE_USER");
//    }
}