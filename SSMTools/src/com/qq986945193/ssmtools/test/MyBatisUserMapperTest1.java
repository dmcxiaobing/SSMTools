package com.qq986945193.ssmtools.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * 使用Mapper接口进行测试
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class MyBatisUserMapperTest1 {

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
	 * 使用mapper接口测试根据用户ID查找用户
	 */
	@Test
	public  void testFindUserById(){
		
	}
	
}
