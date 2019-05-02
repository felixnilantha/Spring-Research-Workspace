package com.spring.research.security.dao;

import com.spring.research.security.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
