package com.collaborate.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.dao.BlogCategoryDao;
import com.collaborate.model.BlogCategory;

@Service("blogCategoryService")
@Transactional
@PersistenceContext
public class BlogCategoryServiceImpl implements BlogCategoryService {

	@Autowired

	BlogCategoryDao blogCategoryDao;

	@Transactional
	public void addBlogCategory(BlogCategory blogCategory) {

		blogCategoryDao.addBlogCategory(blogCategory);
	}

	@Transactional
	public BlogCategory getBlogCategory(int blogCategoryId) {

		return blogCategoryDao.getBlogCategory(blogCategoryId);
	}

	@Transactional
	public ArrayList<BlogCategory> getAllBlogCategory() {
		// TODO Auto-generated method stub
		ArrayList<BlogCategory> list = new ArrayList<BlogCategory>();
		list = (ArrayList<BlogCategory>) blogCategoryDao.getAllBlogCategory();

		return list;
	}

}
