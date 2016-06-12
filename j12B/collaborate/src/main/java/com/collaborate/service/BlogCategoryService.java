package com.collaborate.service;

import java.util.ArrayList;
import java.util.List;

import com.collaborate.model.BlogCategory;

public interface BlogCategoryService {
	public void addBlogCategory(BlogCategory blogCategory); // insert
	   public BlogCategory getBlogCategory(int blogCategoryId);
	   public ArrayList<BlogCategory> getAllBlogCategory();
}
