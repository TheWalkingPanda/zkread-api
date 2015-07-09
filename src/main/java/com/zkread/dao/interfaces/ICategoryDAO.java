package com.zkread.dao.interfaces;

import java.util.List;

import com.zkread.domain.Article;
import com.zkread.domain.Category;

public interface ICategoryDAO {
	public Category getCategoryById(long categoryId);
	public List<Article> getCategoryArticles(long categoryId);
}
