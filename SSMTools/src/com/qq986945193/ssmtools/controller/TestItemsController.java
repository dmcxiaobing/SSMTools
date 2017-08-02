package com.qq986945193.ssmtools.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qq986945193.ssmtools.constants.Urls;
import com.qq986945193.ssmtools.pojo.SpringMvcItems1;

/**
 * 一个简单的controller
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
//首先使用注解成为Controller
@Controller
public class TestItemsController {

	//指定url到请求方法的映射.因为我们web.xml配置的是拦截*.action所以。
	//url中输入一个地址，找到这个方法，例如：localhost:8080/ssmtools/list.action
	@RequestMapping("/list")
	public ModelAndView itemsList(){
		//这里就是简单的获取数据
		List<SpringMvcItems1> items = initData();
		
		//需要模型和视图，ModelAndView
		//model模型：模型对象中存放了返回给页面的数据
		//view视图；视图对象中制定了返回的页面的位置
		ModelAndView modelAndView = new ModelAndView();
		//将返回个页面的数据存入到模型和视图对象中
		modelAndView.addObject("itemList",items);
		//不配置InternalResourceViewResolver,需要指定全路径和名称
		modelAndView.setViewName("/SpringMvc/jsp/itemList.jsp");
		//指定返回的页面的位置.由于我们在SpringMvc.xml中配置了视图解析器，所以不用写前缀和后缀路径。
		//modelAndView.setViewName("itemList");
		
		return modelAndView;
	}
	/**
	 * 就是初始化数据而已
	 * @return 
	 */
	private List<SpringMvcItems1> initData() {
		List<SpringMvcItems1> items = new ArrayList<SpringMvcItems1>();
		SpringMvcItems1 items1 = new SpringMvcItems1();
		items1.setDetail("david springmvc");
		items1.setId(1);
		items1.setName("程序员小冰QQ986945193");
		SpringMvcItems1 items2 = new SpringMvcItems1();
		items2.setDetail("程序员小冰 springmvc");
		items2.setId(1);
		items2.setName(Urls.CSDN_DAVID);
		SpringMvcItems1 items3 = new SpringMvcItems1();
		items3.setDetail(Urls.GITHUB_DAVID);
		items3.setId(1);
		items3.setName("程序员小冰QQ986945193");
		items.add(items1);
		items.add(items2);
		items.add(items3);
		return items;
	}
}
