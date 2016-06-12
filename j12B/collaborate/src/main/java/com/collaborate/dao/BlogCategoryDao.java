package com.collaborate.dao;

import java.util.List;

import com.collaborate.model.BlogCategory;

public interface BlogCategoryDao {

	public void addBlogCategory(BlogCategory blogCategory); // insert
	   public BlogCategory getBlogCategory(int blogCategoryId);
	   public List<BlogCategory> getAllBlogCategory();
}
