package com.qq986945193.ssmtools.pojo;

import java.util.Date;

/**
 * 一个实体类
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class MyBatisUser1 {

	private int id;
	private String username;//用户名
	private String sex;//性别
	private Date birthday;//生日
	private String address;//地址
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		return "MyBatisUser1 [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}
	
}
