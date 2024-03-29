package com.qq986945193.ssmtools.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;

import com.qq986945193.ssmtools.pojo.MyBatisUser1;

/**
 * 入门简单的测试
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class MyBatisTest1 {
	/**
	 * 根据id查询用户信息,因为web项目，编译后会到classes目录下。所以路径写法不同
	 */
	@Test
	public void testFindUserById() throws Exception {
		String resource = "config/SqlMapConfig.xml";
		// 通过输入流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建session
		SqlSession session = sessionFactory.openSession();
		// 第一个参数：所调用的sql语句=namespace+.+sql的id
		MyBatisUser1 user = session.selectOne("test.findUserById", 1);
		System.out.println(user);
		// 关闭session
		session.close();
	}

	/**
	 * 根据用户名查询用户 ，返回一个用户集合.使用模糊查询
	 */
	@Test
	public void testFindUserByUsername() throws Throwable {
		String resource = "config/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 得到sessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到session
		SqlSession sqlSession = factory.openSession();
		// 查询返回用户信息，这里返回一个用户集合。
		List<MyBatisUser1> lists = sqlSession.selectList("test.findUserByUsername", "david");
		System.out.println(lists);
	}

	/**
	 * 插入用户
	 */
	@Test
	public void insertUser() throws Exception {
		String resource = "config/SqlMapConfig.xml";
		// 通过输入流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建session
		SqlSession session = sessionFactory.openSession();
		//创建一个用户
		MyBatisUser1 user1 = new MyBatisUser1();
		user1.setId(22);
		user1.setUsername("986945193@qq.com");
		user1.setAddress("http://weibo.com/mcxiaobing");
		user1.setBirthday(new Date());
		user1.setSex("boy");
		session.insert("test.insertUser",user1);
		//提交事务MyBatis会自动开启事务，但是它不知道何时提交，所以需要手动提交事务
		session.commit();
	}

	/**
	 * 根据用户ID删除用户
	 */
	@Test
	public void deleteUserById() throws Exception{
		String resource = "config/SqlMapConfig.xml";
		// 通过输入流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建session
		SqlSession session = sessionFactory.openSession();
		session.delete("test.deleteUserById", 1);
		session.commit();
	}
	/**
	 * 更新用户的信息
	 */
	@Test
	public void updateUserById() throws Exception{
		String resource = "config/SqlMapConfig.xml";
		// 通过输入流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建session
		SqlSession session = sessionFactory.openSession();
		MyBatisUser1 user1 = new MyBatisUser1();
		user1.setId(2);
		user1.setUsername("mybatis");
		session.update("test.updateUserById", user1);
		session.commit();
	}
	
	
	
	
	
	
	
	
	
	
}
