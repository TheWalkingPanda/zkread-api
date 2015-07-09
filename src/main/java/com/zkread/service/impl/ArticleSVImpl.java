package com.zkread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkread.dao.interfaces.IArticleDAO;
import com.zkread.domain.Article;
import com.zkread.service.interfaces.IArticleSV;

@Service
public class ArticleSVImpl implements IArticleSV {
	
	@Autowired
	private IArticleDAO articleDao;

	public long saveArticle(Article article) {
		return articleDao.saveArticle(article);
	}

	public Article getArticleById(long articleId) {
		return articleDao.getArticleById(articleId);
	}
}
