package com.izibiz.training.bean.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.izibiz.training.dao.base.UsersDao;
import com.izibiz.training.entity.Users;

@Transactional
public class CustomUserDetailsService  implements UserDetailsService  {

	@Autowired
    private UsersDao usersDao;
			
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	Users users = usersDao.findByUsername(username);
    	        
        if(users ==null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        
        return new CustomUserDetails(users);
    }
}
