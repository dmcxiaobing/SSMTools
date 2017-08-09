package com.qq986945193.ssmtools.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qq986945193.ssmtools.mapper.MyBatisUserMapper1;
import com.qq986945193.ssmtools.mapper.UserMapper;
import com.qq986945193.ssmtools.pojo.MyBatisUser1;
import com.qq986945193.ssmtools.pojo.User;
import com.qq986945193.ssmtools.pojo.UserExample;
import com.qq986945193.ssmtools.pojo.UserExample.Criteria;
/**
 * 使用spring+mybatis测试。dao交于mapper
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class SMMapperTest {
	private ApplicationContext applicatonContext;
	
	@Before
	public void setUp() throws Exception{
		String configLocation = "classpath:ApplicationContext.xml";
		applicatonContext = new ClassPathXmlApplicationContext(configLocation);
	}
	
	
	@Test
	public void  testFindUserById() throws Exception{
		MyBatisUserMapper1 userMapper = (MyBatisUserMapper1) applicatonContext.getBean("myBatisUserMapper1");
		MyBatisUser1 user = userMapper.findUserById(2);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByMapperId() throws Exception{
		UserMapper userMapper = (UserMapper) applicatonContext.getBean("userMapper");
		User user1 = (User) userMapper.selectByPrimaryKey(2);
		System.out.println(user1);
	}
	
	@Test
	public void testFindUserAndSex() throws Exception{
		UserMapper mapper = (UserMapper) applicatonContext.getBean("userMapper");
		//创建UserExmaple对象
		UserExample userExample = new UserExample();
		//通过UserExample对象创建查询条件封装对象。（Criteria中是封装的查询条件）
		Criteria criteria = userExample.createCriteria();
		//加入查询条件
		criteria.andUsernameLike("%d%");
		criteria.andSexEqualTo("man");
		List<User> list = mapper.selectByExample(userExample);
		System.out.println(list);
	}
}
