package com.qq986945193.ssmtools.pojo;
/**
 * 一个订单的类
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */

public class MyBatisOrders1 {
	private Integer id;
	private Integer user_id;
	private String number;
	private String createtime;
	private String note;
	private MyBatisUser1 user;
	
	public MyBatisUser1 getUser() {
		return user;
	}
	public void setUser(MyBatisUser1 user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
