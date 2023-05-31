package com.inn.cafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.inn.cafe.POJO.Bill;

public interface BillDao extends JpaRepository<Bill, Integer>{
	
	List<Bill> getAllBills();
	
	List<Bill> getBillByUserName(@Param("username") String username);

}
