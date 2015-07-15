package com.zkread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkread.dao.interfaces.ICommonDAO;
import com.zkread.domain.Article;
import com.zkread.service.interfaces.IArticleSV;

@Service
public class ArticleSVImpl implements IArticleSV {
	
	@Autowired
	private ICommonDAO<Article> commonDao;

	public long saveArticle(Article newArticle) {
		return commonDao.save(newArticle);
	}

	public Article getArticleById(long articleId) {
		Article theArticle = new Article();
		theArticle.setId(articleId);
		return commonDao.getById(theArticle);
	}
}
