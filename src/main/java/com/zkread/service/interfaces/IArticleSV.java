package com.zkread.service.interfaces;

import com.zkread.domain.Article;

public interface IArticleSV {
	public long saveArticle(Article article);
	public Article getArticleById(long articleId);
}
