package com.qq986945193.ssmtools.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * jedis的简单使用教程。
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class JedisTest {

	/*
	 * 简单用连接操作redis
	 */
	@Test
	public void testJedis(){
		//创建redis的连接
		Jedis jedis = new Jedis("192.168.1.1", 6379);
		//存入数据
		jedis.set("key1", "1");
		//取出
		System.out.println(jedis.get("key1"));
		//关闭连接
		jedis.close();
	}
	
	/**
	 * 使用连接池操作redis
	 */
	@Test
	public void testJedisPool()throws Exception{
		//创建连接池
		JedisPool pool = new JedisPool("192.168.1.1", 6379);
		//获取连接
		Jedis jedis = pool.getResource();
		//存入数据
		jedis.set("key2", "key2");
		//取出
		System.out.println(jedis.get("key2"));
		//使用连接时，使用完毕后一定要关闭，否则不会释放，则会卡死
		//关闭连接,关闭连接池
		jedis.close();
		pool.close();
	}
	
	/**
	 * 使用spring整合jedis，这样就不用我们手动关闭了，全部交给spring管理
	 */
	
	private ApplicationContext applicationContext;
	/**
	 * spring整合后，测试jedis
	 */
	@Test
	public void testJedisSpring()throws Exception{
		String location = "classpath:config/ApplicationContext-jedis.xml";
		applicationContext = new ClassPathXmlApplicationContext(location);
		//获取连接池
		JedisPool pool = (JedisPool) applicationContext.getBean("jedisPool");
		//获取连接
		Jedis jedis = pool.getResource();
		//设置数据
		jedis.set("spring", "spring");
		//取出，不用关闭，因为已经交给了spring管理
		System.out.println(jedis.get("spring"));
	}

}
