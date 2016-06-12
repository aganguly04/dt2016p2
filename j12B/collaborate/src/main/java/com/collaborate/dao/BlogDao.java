package com.collaborate.dao;

import java.util.List;

import com.collaborate.model.Blog;

public interface BlogDao {

	public void addBlog(Blog blog,int blogCategoryId); // insert
	   public Blog getBlog(int blogid);  
	   public List<Blog> getComments(int blogId);
	  // public int countComments(int blogId);
	   public  List<Object[]>    getAllBlogs();
	 //  public  List<Blog>    getAllBlogsGroupByTitle();  //  group by title

	
	
}
