package com.company.dao;

import java.util.List;

import com.company.model.Category;

public interface CategoryDAO {
	public void addCategory( Category category );
	public void deleteCategory( int categoryId );
	public void updateCategory( Category category );
	public List<Category> getAllCategoryss();
	public Category getCategoryById( int categoryId );
	List<Category> getAllCategorys();
}