package com.al._01springsecuritydemo01.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.al._01springsecuritydemo01.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
