package com.zkread.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.zkread.dao.interfaces.IArticleDAO;
import com.zkread.domain.Article;

@Repository
public class ArticleDAOImpl implements IArticleDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public long saveArticle(Article article) {
		Object result = sqlMapClientTemplate.insert("saveArticle", article);
		return Long.parseLong(result.toString());
	}

	public Article getArticleById(long articleId) {
		return (Article) sqlMapClientTemplate.queryForObject("getArticleById", articleId);
	}

}
