package com.izibiz.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.izibiz.training.dao.base.UsersDao;
import com.izibiz.training.entity.Users;
import com.izibiz.training.service.base.UsersService;

@Transactional
public class UsersServiceImp implements UsersService{

	@Autowired
	private UsersDao usersDao;
	
	
	
	
	
}
