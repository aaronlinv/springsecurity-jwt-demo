package com.al._01springsecuritydemo01.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.al._01springsecuritydemo01.entity.User;

@Service
public class JwtAuthService {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String username, String password) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new RuntimeException("用户名或密码有误");
        }
        User loginUser = (User) authentication.getPrincipal();
        return jwtTokenUtils.generateToken(loginUser);
    }
}
