package com.qq986945193.ssmtools.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qq986945193.ssmtools.dao.MyBatisUserDao1;
import com.qq986945193.ssmtools.dao.impl.MyBatisUserDaoImpl1;
import com.qq986945193.ssmtools.pojo.MyBatisUser1;

/**
 * 测试我们的mvc开发模式
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class MyBatisUserDaoTest1 {

	private SqlSessionFactory sqlSessionFactory;
	/**
	 * before作用：在测试方法执行之前会执行此方法
	 */
	@Before
	public void setUp() throws IOException{
		String resource = "config/SqlMapConfig.xml";
		//通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过核心配置文件输入流来创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * 根据用户id查找用户
	 */
	@Test
	public void findUserById(){
		//将初始化好的工厂注入到实现类中
		MyBatisUserDao1 dao1 = new MyBatisUserDaoImpl1(sqlSessionFactory);
		MyBatisUser1 user1 = dao1.findUserById(22);
		System.out.println(user1);
	}
	
	/**
	 * 根据用户名模糊查询用户数据
	 */
	@Test
	public void findUserByUsername(){
		MyBatisUserDao1 dao = new MyBatisUserDaoImpl1(sqlSessionFactory);
		List<MyBatisUser1> list = dao.findUserByUsername("david");
		System.out.println(list);
	}
}
