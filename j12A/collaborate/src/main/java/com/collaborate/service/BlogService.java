package com.collaborate.service;

import java.util.ArrayList;
import java.util.List;

import com.collaborate.model.Blog;

public interface BlogService {

	public void addBlog(Blog blog,int blogCategoryId); // insert
	   public Blog getBlog(int blogid);  
	   public ArrayList<Blog> getComments(int blogId);
	  // public int countComments(int blogId);
	   public  ArrayList<Object[]>    getAllBlogs();
	 //  public  List<Blog>    getAllBlogsGroupByTitle();  //  group by title

	
	
}
