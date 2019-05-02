package com.spring.research.security.service;

import com.spring.research.security.entity.User;
import com.spring.research.security.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
