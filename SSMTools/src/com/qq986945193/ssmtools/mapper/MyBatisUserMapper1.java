package com.qq986945193.ssmtools.mapper;

import java.util.List;

import com.qq986945193.ssmtools.pojo.MyBatisUser1;

/**
 * 动态代理的方法实现
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface MyBatisUserMapper1 {
	//根据用户id查找到用户信息
	public MyBatisUser1 findUserById(Integer id);

	//动态代理形式中。如果返回结果集List，那么mybatis会在生成实现类的时候自动调用selectList方法
	public List<MyBatisUser1> findUserByUsername();


	public void insertUser(MyBatisUser1 user1);

}
