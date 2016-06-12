package com.collaborate.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.dao.BlogCategoryDao;
import com.collaborate.dao.BlogDao;

import com.collaborate.model.Blog;
import com.collaborate.model.BlogCategory;
import com.collaborate.model.BlogDto;
@Service("blogService")
@Transactional
@PersistenceContext
public class BlogServiceImpl implements BlogService {

	
	@Autowired

	BlogDao blogDao;

	public void addBlog(Blog blog, int blogCategoryId) {
		
			blogDao.addBlog(blog, blogCategoryId);
	}

	public Blog getBlog(int blogid) {
		// TODO Auto-generated method stub
		
		return blogDao.getBlog(blogid);
	}

	public ArrayList<Blog> getComments(int blogId) {
		// TODO Auto-generated method stub
		
		ArrayList<Blog> list = new ArrayList<Blog>();
		
		
		list = (ArrayList<Blog>) blogDao.getComments(blogId);

		return list;

	}

	public ArrayList<BlogDto> getAllBlogs() {
		// TODO Auto-generated method stub
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		ArrayList<BlogDto> dtoList = new ArrayList<BlogDto>();
		list = (ArrayList<Object[]>) blogDao.getAllBlogs();
		
		for (Object[] aRow : list) {
		    Blog b = (Blog) aRow[0];
		    BlogCategory bc = (BlogCategory) aRow[1];
		    
		    BlogDto bd=new BlogDto(b.getBlogId(),b.getName(),b.getTitle(),b.getComment(),b.getDatePosted(),b.getBlogChildId(),bc.getCategoryName());
		    dtoList.add(bd);
		    System.out.println(bd.getName() + " - " + bd.getBlogCategory());
		}
		
		
		
		return dtoList;
	}

}
