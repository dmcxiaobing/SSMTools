package com.qq986945193.ssmtools.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qq986945193.ssmtools.dao.MyBatisUserDao1;
import com.qq986945193.ssmtools.dao.UserDao;
import com.qq986945193.ssmtools.pojo.MyBatisUser1;

/**
 * 这是一个spring与mybatis的测试类。
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class SMTest {
	private ApplicationContext applicationContext;
	/**
	 * 加载配置文件	
	 */
	@Before
	public void setUp(){
		String configLocation = "classpath:ApplicationContext.xml";
		applicationContext = new ClassPathXmlApplicationContext(configLocation);
	}
	
	@Test
	public void testFindUserById() throws Exception{
		//获取Dao对象。利用getBean获取。
		UserDao dao = (UserDao) applicationContext.getBean("userDao");
		MyBatisUser1 user = dao.findUserById(2);
		System.out.println(user);
	}
	
}
