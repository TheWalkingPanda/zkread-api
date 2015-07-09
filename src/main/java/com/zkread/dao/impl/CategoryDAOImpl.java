package com.zkread.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.zkread.dao.interfaces.ICategoryDAO;
import com.zkread.domain.Article;
import com.zkread.domain.Category;

@Repository
public class CategoryDAOImpl implements ICategoryDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public Category getCategoryById(long categoryId) {
		return (Category) sqlMapClientTemplate.queryForObject("getCategoryById", categoryId);
	}

	@SuppressWarnings("unchecked")
	public List<Article> getCategoryArticles(long categoryId) {
		return sqlMapClientTemplate.queryForList("getCategoryArticles", categoryId);
	}
	
}
