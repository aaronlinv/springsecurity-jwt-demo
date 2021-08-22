package com.al._01springsecuritydemo01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.al._01springsecuritydemo01.dao.UserDao;
import com.al._01springsecuritydemo01.entity.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByUserName(String username) {
        User user = new User();
        user.setUserName(username);
        List<User> list = userDao.findAll(Example.of(user));
        return list.isEmpty() ? null : list.get(0);
    }
}
