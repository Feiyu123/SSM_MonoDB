package com.lrq.test;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.lrq.dao.MongoDBBaseDao;
import com.lrq.entity.User;



public class TestBaseDao extends BaseTest{

	@Resource(name = "mongoDBBaseDao")
	MongoDBBaseDao mongoDBBaseDao;
	
	@Test
	public void testAdd(){
		User user=new User();
		Date creatTime=new Date();
		user.setCreateTime(creatTime);
		user.setAge(10);
		user.setUserName("liurenquan");
		this.mongoDBBaseDao.add(user);
	}
	@Test
	public void testFindAll(){
		List<User> userList=this.mongoDBBaseDao.findAll(User.class);
		for (User user : userList) {
			System.out.println("id:"+user.getId()+"username:"+user.getUserName()+"age:"+user.getAge());
		}
		System.out.println("获取全部的数据----------------------");
	}
	
	@Test
	public void testFindById(){
		User user=this.mongoDBBaseDao.findById(User.class, "1234567");
		System.out.println(user.getUserName());
		System.out.println("获取单个对象----------------------");
	}
	@Test
	public void testUpdate(){
		User user=this.mongoDBBaseDao.findById(User.class, "1234567");
		user.setUserName("黄江淮");
		this.mongoDBBaseDao.saveOrUpdate(user);
		User newUser=this.mongoDBBaseDao.findById(User.class, "1234567");
		System.out.println(newUser.getUserName());
		System.out.println("修改数据成功");
		this.mongoDBBaseDao.saveOrUpdate(user);
	}
	@Test
	public void testRemove(){
		User user=this.mongoDBBaseDao.findById(User.class, "1234567");
		this.mongoDBBaseDao.remove(user);
		User oldUser=this.mongoDBBaseDao.findById(User.class, "1234567");
		if(oldUser==null){
			System.out.println(oldUser==null);
			System.out.println("删除对象成功");
		}
		this.mongoDBBaseDao.add(user);
	}
	
	@Test
	public void testCount(){
		Query query=new Query();
		Criteria criteria=new Criteria();
		criteria.and("username").is("黄江南");
		query.addCriteria(criteria);
		long total=this.mongoDBBaseDao.count(User.class, query);
		System.out.println("用户总数:"+total);
	}
}
