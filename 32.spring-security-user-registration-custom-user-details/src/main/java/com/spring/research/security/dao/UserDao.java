package com.spring.research.security.dao;

import com.spring.research.security.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
