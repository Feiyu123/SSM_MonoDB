package com.lrq.dao;

import java.util.List;

public interface BaseDao {

	<T> T findById(Class<T> entityClass, String id);

	<T> List<T> findAll(Class<T> entityClass);

	void remove(Object obj);

	void add(Object obj);

	void saveOrUpdate(Object obj);
}
