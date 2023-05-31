package com.inn.cafe.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.jboss.logging.BasicLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inn.cafe.dao.UserDao;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@Slf4j

@Service
public class CustomerUsersDetailsService implements UserDetailsService{

	@Autowired
	UserDao userDao;
	
	private com.inn.cafe.POJO.User userDetail;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BasicLogger("Inside loadUserByUsername {}",username);
		userDetail = userDao.findByEmailId(username);
		
		if(!Objects.isNull(userDetail))
			return new User(userDetail.getEmail(),userDetail.getPassword(), new ArrayList<>());
		else
			throw new UsernameNotFoundException("User not found...");
		
	}
	
	private void BasicLogger(String string, String username) {
		
	}

	public com.inn.cafe.POJO.User getUserDetail(){

		return userDetail;
	} 
}
