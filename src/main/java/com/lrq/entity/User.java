package com.lrq.entity;

import java.util.Date;

public class User {
	private String id;
	private String userName;
	private int age;
	private Date createTime;
	
	public User() {
		super();
	}

	public User(String id, String userName, int age, Date createTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age
				+ ", createTime=" + createTime + "]";
	}
	
}
