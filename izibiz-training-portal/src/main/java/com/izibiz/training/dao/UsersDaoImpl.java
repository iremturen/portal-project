package com.izibiz.training.dao;

import java.net.URI;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.izibiz.training.bean.security.AuthenticationRequest;
import com.izibiz.training.bean.security.AuthenticationResponse;
import com.izibiz.training.dao.base.UsersDao;
import com.izibiz.training.dao.common.GenericDaoHibernateImpl;
import com.izibiz.training.entity.Users;
import com.izibiz.training.entity.dto.Root;

@Repository
public class UsersDaoImpl extends GenericDaoHibernateImpl<Users> implements UsersDao {

	private static final Logger logger = Logger.getLogger(UsersDaoImpl.class);
	private static final long serialVersionUID = 123L;

	@Autowired
	private RestTemplate restTemplate;

	public UsersDaoImpl() {
		super(Users.class);
	}

	@Override
	public Users findByUsername(String username) {
		String sql = "select * from users where username=:username";
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sql).addEntity(Users.class);
		sqlQuery.setParameter("username", username);
		Users users = (Users) sqlQuery.uniqueResult();
		return users;

	}


	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
