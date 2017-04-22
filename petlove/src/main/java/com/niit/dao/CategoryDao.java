package com.niit.dao;

import java.util.List;
import java.util.Map;

import com.niit.model.Category;

public interface CategoryDao
{
	public boolean newCategory(Category category);
	public Category getCategory(int id);
	public List<Category> allCategories();
	public boolean deleteCategory(int id);
	public boolean updateCategory(Category category);
	public Map<Integer,String> getCatForPro();

}
