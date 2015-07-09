package com.zkread.dao.interfaces;

import com.zkread.domain.Article;

public interface IArticleDAO {
	public long saveArticle(Article article);
	public Article getArticleById(long articleId);
}
