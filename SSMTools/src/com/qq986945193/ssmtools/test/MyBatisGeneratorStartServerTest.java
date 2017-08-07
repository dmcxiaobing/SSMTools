package com.qq986945193.ssmtools.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 使用mybatis逆向工程
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class MyBatisGeneratorStartServerTest {
	
	/**
	 * 逆向生成
	 */
	public void gengerator()throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("config/generatorConfig.xml"); 
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	
	public static void main(String[] args) {
		try {
			MyBatisGeneratorStartServerTest serverTest = new MyBatisGeneratorStartServerTest();
			serverTest.gengerator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
