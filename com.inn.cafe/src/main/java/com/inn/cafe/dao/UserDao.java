package com.inn.cafe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.inn.cafe.POJO.User;
import com.inn.cafe.wrapper.UserWrapper;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmailId(@Param("email") String email);
	
	List<UserWrapper> getAllUser();
	
	List<String> getAllAdmin();
	
	@Transactional
	@Modifying
	Integer updateStatus (@Param("status") String status, @Param("id") Integer id);
	
	User findByEmail(String email);

}
