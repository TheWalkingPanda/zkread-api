package com.zkread.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.zkread.dao.interfaces.ICategoryDAO;
import com.zkread.domain.Article;

@Repository
public class CategoryDAOImpl implements ICategoryDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Article> getCategoryArticles(long categoryId) {
		return sqlMapClientTemplate.queryForList("getCategoryArticles", categoryId);
	}
	
}
