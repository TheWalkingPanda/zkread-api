package com.zkread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkread.dao.interfaces.ICategoryDAO;
import com.zkread.dao.interfaces.ICommonDAO;
import com.zkread.domain.Article;
import com.zkread.domain.Category;
import com.zkread.service.interfaces.ICategorySV;

@Service
public class CategorySVImpl implements ICategorySV {

	@Autowired
	private ICommonDAO<Category> commonDao;
	
	@Autowired
	private ICategoryDAO categoryDao;
	
	public Category getCategoryById(long categoryId) {
		Category theCategory = new Category();
		theCategory.setId(categoryId);
		return commonDao.getById(theCategory);
	}

	public List<Article> getCategoryArticles(long categoryId) {
		return categoryDao.getCategoryArticles(categoryId);
	}

}
