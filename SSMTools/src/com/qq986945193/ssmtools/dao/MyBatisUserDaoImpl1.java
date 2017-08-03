package com.qq986945193.ssmtools.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.qq986945193.ssmtools.pojo.MyBatisUser1;
/**
 * 这里用来测试我们的原来的dao开发
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class MyBatisUserDaoImpl1 implements MyBatisUserDao1 {
	private SqlSessionFactory sqlSessionFactory;
	//通过构造方法进行注入初始化SqlSessionFactory
	public MyBatisUserDaoImpl1(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	/**
	 * 根据用户ID查找用户
	 */
	public MyBatisUser1 findUserById(Integer id) {
		//SqlSession是线程不安全的，所以它的最佳使用范围在方法体内
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyBatisUser1 user1 = sqlSession.selectOne("test.findUserById", id);
		return user1;
	}
	/**
	 * 根据用户名模糊查找用户列表
	 */
	public List<MyBatisUser1> findUserByUsername(String username) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MyBatisUser1> lists = sqlSession.selectList("test.findUserByUsername", username);
		return lists;
	}

}
