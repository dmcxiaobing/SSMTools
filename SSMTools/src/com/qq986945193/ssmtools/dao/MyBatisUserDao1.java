package com.qq986945193.ssmtools.dao;

import java.util.List;

import com.qq986945193.ssmtools.pojo.MyBatisUser1;

/**
 * 一个简单的dao 用来测试dao的开发
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface MyBatisUserDao1 {
	//根据id查找用户
	public MyBatisUser1 findUserById(Integer id);
	//根据用户名查找用户。返回集合。模糊查询
	public List<MyBatisUser1> findUserByUsername(String username);


	

}
