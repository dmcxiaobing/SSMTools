package com.qq986945193.ssmtools.dao.impl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qq986945193.ssmtools.dao.UserDao;
import com.qq986945193.ssmtools.pojo.MyBatisUser1;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	

	@Override
	public MyBatisUser1 findUserById(Integer id) {
		//sqlSesion是线程不安全的,所以它的最佳使用范围在方法体内
		SqlSession openSession = this.getSqlSession();
		MyBatisUser1 user = openSession.selectOne("test.findUserById", id);
		//整合后会话归spring管理,所以不需要手动关闭.
		//openSession.close();
		return user;
	}

	@Override
	public List<MyBatisUser1> findUserByUserName(String userName) {
		SqlSession openSession = this.getSqlSession();
		List<MyBatisUser1> list = openSession.selectList("test.findUserByUserName", userName);
		return list;
	}
	
	
}
