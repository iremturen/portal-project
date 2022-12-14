package com.izibiz.training.dao.base;

import java.util.Map;

import com.izibiz.training.bean.security.AuthenticationRequest;
import com.izibiz.training.dao.common.GenericDao;
import com.izibiz.training.entity.Users;

public interface UsersDao extends GenericDao<Users>{
	
	Users findByUsername(String username); 

}
