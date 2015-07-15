package com.zkread.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.zkread.dao.interfaces.ICommonDAO;
import com.zkread.util.ReflectUtil;

@Repository
@SuppressWarnings("unchecked")
public class CommonDAOImpl<E> implements ICommonDAO<E> {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public long save(E newObj) {
		Object result = sqlMapClientTemplate.insert("save"+ReflectUtil.getClassSimpleName(newObj), newObj);
		return Long.parseLong(result.toString());
	}

	public int del(E delObj) {
		return sqlMapClientTemplate.update("del"+ReflectUtil.getClassSimpleName(delObj), delObj);
	}

	public int update(E updateObj) {
		return sqlMapClientTemplate.update("update"+ReflectUtil.getClassSimpleName(updateObj), updateObj);
	}

	public E getById(E theObj) {
		return (E) sqlMapClientTemplate.queryForObject("get"+ReflectUtil.getClassSimpleName(theObj)+"ById", theObj);
	}

	public List<E> getByParam(E paramObj) {
		return sqlMapClientTemplate.queryForList("get"+ReflectUtil.getClassSimpleName(paramObj)+"sByParam", paramObj);
	}
	
}
