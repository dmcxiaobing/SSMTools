package com.qq986945193.ssmtools.mapper;

import java.util.List;

import com.qq986945193.ssmtools.pojo.MyBatisUser1;
import com.qq986945193.ssmtools.pojo.MyBatisUserQueryVo1;

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
	public List<MyBatisUser1> findUserByUsername(String username);


	public void insertUser(MyBatisUser1 user1);

	public List<MyBatisUser1> findUserByVo(MyBatisUserQueryVo1 vo1);

	public Integer findUserCount();

	public List<MyBatisUser1> findUserByUsernameAndSex();

	public List<MyBatisUser1> findUserByIds(MyBatisUserQueryVo1 vo1);
}
