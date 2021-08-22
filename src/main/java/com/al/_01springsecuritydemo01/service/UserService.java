package com.al._01springsecuritydemo01.service;

import com.al._01springsecuritydemo01.entity.User;

public interface UserService {
    public User selectUserByUserName(String username);
}
