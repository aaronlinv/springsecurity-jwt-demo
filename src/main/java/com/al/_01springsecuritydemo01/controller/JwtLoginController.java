package com.al._01springsecuritydemo01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.al._01springsecuritydemo01.common.RestResult;
import com.al._01springsecuritydemo01.config.jwt.JwtAuthService;
@RestController
public class JwtLoginController {
    @Autowired
    private JwtAuthService jwtAuthService;


    @PostMapping({"/login", "/"})
    public RestResult login(String username, String password) {
        RestResult result = RestResult.success();
        String token = jwtAuthService.login(username, password);
        result.put("token", token);
        return result;
    }
}
