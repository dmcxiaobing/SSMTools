package com.qq986945193.ssmtools.pojo;

import java.util.Date;
/**
 * 继承order，然后加入用户的字段.如果继承，则父类中去掉user对象
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class MyBatisCustomerOrders extends MyBatisOrders1{

	private Integer id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MyBatisCustomerOrders [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}
	
}
