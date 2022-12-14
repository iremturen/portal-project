package com.izibiz.training.bean.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.izibiz.training.dao.base.UsersDao;
import com.izibiz.training.entity.Users;

import lombok.SneakyThrows;


@Component
public class AuthenticationSuccessHandlerImp extends SimpleUrlAuthenticationSuccessHandler {
		

	
	@SneakyThrows
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	    
		 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	     String username = userDetails.getUsername();
	     System.out.println("The user " + username + " has logged in.");
	    super.onAuthenticationSuccess(request, response, authentication);
	     
	     
	    
	     
	}
	
	
	
	

}
