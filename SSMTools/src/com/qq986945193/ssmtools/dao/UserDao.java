package com.qq986945193.ssmtools.dao;

import java.util.List;

import com.qq986945193.ssmtools.pojo.MyBatisUser1;


public interface UserDao {

	public MyBatisUser1 findUserById(Integer id);
	
	public List<MyBatisUser1> findUserByUserName(String userName);
}
