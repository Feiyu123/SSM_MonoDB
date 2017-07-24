package com.lrq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lrq.page.Page;



/**
 * mongodb数据泛型dao类
 * 
 * @author liurenquan
 * @version 
 */
@Repository(value = "mongoDBBaseDao")
public class MongoDBBaseDao implements BaseDao {
	@Autowired
	@Qualifier("mongoTemplate")
	protected MongoTemplate mongoTemplate;

	/**
	 * 根据主键id返回对象
	 * 
	 * @param id
	 *            唯一标识
	 * @return T 对象
	 */
	public <T> T findById(Class<T> entityClass, String id) {
		return this.mongoTemplate.findById(id, entityClass);
	}

	/**
	 * 根据类获取全部的对象列表
	 * 
	 * @param entityClass
	 *            返回类型
	 * @return List<T> 返回对象列表
	 */
	public <T> List<T> findAll(Class<T> entityClass) {
		return this.mongoTemplate.findAll(entityClass);
	}

	/**
	 * 删除一个对象
	 * 
	 * @param obj
	 *            要删除的Mongo对象
	 */
	public void remove(Object obj) {
		this.mongoTemplate.remove(obj);
	}

	/**
	 * 添加对象
	 * 
	 * @param obj
	 *            要添加的Mongo对象
	 */
	public void add(Object obj) {
		this.mongoTemplate.insert(obj);

	}

	/**
	 * 修改对象
	 * 
	 * @param obj
	 *            要修改的Mongo对象
	 */
	public void saveOrUpdate(Object obj) {
		this.mongoTemplate.save(obj);
	}

	/**
	 * 查询并分页
	 * 
	 * @param entityClass
	 *            对象类型
	 * @param query
	 *            查询条件
	 * @param page
	 *            分页
	 * @return
	 */
	public <T> List<T> findByQuery(Class<T> entityClass, Query query, Page page) {
		Long count = this.count(entityClass, query);
		page.setCount(count);
		int pageNumber = page.getCurrent();
		int pageSize = page.getPageCount();
		query.skip((pageNumber - 1) * pageSize).limit(pageSize);
		return this.mongoTemplate.find(query, entityClass);
	}

	/**
	 * 
	 * @param entityClass
	 *            查询对象
	 * @param query
	 *            查询条件
	 * @return
	 */
	public <T> Long count(Class<T> entityClass, Query query) {
		return this.mongoTemplate.count(query, entityClass);
	}
}
