package com.zkread.dao.interfaces;

import java.util.List;

import com.zkread.domain.Article;

public interface ICategoryDAO {
	public List<Article> getCategoryArticles(long categoryId);
}
