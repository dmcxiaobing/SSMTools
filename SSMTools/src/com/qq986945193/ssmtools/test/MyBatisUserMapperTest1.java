package com.qq986945193.ssmtools.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qq986945193.ssmtools.mapper.MyBatisUserMapper1;
import com.qq986945193.ssmtools.pojo.MyBatisUser1;
import com.qq986945193.ssmtools.pojo.MyBatisUserQueryVo1;

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
		SqlSession session = sqlSessionFactory.openSession();
		//通过getMapper方法来实例化接口
		MyBatisUserMapper1 mapper1 = session.getMapper(MyBatisUserMapper1.class);
		//调用我们的方法，根据用户ID查询用户
		MyBatisUser1 user1 = mapper1.findUserById(22);
		System.out.println(user1);
	}
	/**
	 * 根据用户名称模糊查询用户列表
	 */
	@Test
	public void testFindUserByUsername(){
		SqlSession session = sqlSessionFactory.openSession();
		//通过getMapper方法来实例化接口
		MyBatisUserMapper1 mapper = session.getMapper(MyBatisUserMapper1.class);
		List<MyBatisUser1> users = mapper.findUserByUsername("david");
		System.out.println(users);
	}
	/**
	 * 测试插入用户
	 */
	@Test
	public void testInsertUser() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		//通过getMapper方法来实例化接口
		MyBatisUserMapper1 mapper1 = session.getMapper(MyBatisUserMapper1.class);
		MyBatisUser1 user1 = new MyBatisUser1();
		user1.setUsername("adminroot");
		user1.setAddress("百度一下，google");
		mapper1.insertUser(user1);
		session.commit();
	}
	
	@Test
	public void testFindUserByVo(){
		SqlSession session = sqlSessionFactory.openSession();
		//通过getMapper方法来实例化接口
		MyBatisUserMapper1 mapper1 = session.getMapper(MyBatisUserMapper1.class);
		MyBatisUserQueryVo1 vo = new MyBatisUserQueryVo1();
		MyBatisUser1 user1 = new MyBatisUser1();
		user1.setUsername("david");
		vo.setUser(user1);
		List<MyBatisUser1> users = mapper1.findUserByVo(vo);
		System.out.println(users);
	}
	
	@Test
	public void testFindUserCount() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		//通过getMapper来实例化接口
		MyBatisUserMapper1 mapper1 = session.getMapper(MyBatisUserMapper1.class);
		Integer count = mapper1.findUserCount();
		System.out.println("count:"+count);
	}
	/**
	 * 抽取sql语句 。
	 */
	@Test
	public void testFindUserByUsernameAndSex() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		//通过getMapper方法来实例化接口
		MyBatisUserMapper1 mapper1 = session.getMapper(MyBatisUserMapper1.class);
		MyBatisUser1 user1 = new MyBatisUser1();
		user1.setUsername("david");
		user1.setSex("man");
		List<MyBatisUser1> users = mapper1.findUserByUsernameAndSex();
		System.out.println(users);
	}

	/**
	 * 根据多个id查询用户
	 */
	@Test
	public void testFindUserByIds() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		//通过getMapper方法来实例化接口
		MyBatisUserMapper1 mapper1 = session.getMapper(MyBatisUserMapper1.class);
		MyBatisUserQueryVo1 vo1 = new MyBatisUserQueryVo1();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		ids.add(22);
		vo1.setIds(ids);
		List<MyBatisUser1> users = mapper1.findUserByIds(vo1);
		System.out.println(users);
	}

}
