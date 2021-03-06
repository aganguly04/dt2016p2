package com.collaborate.service;

import java.util.ArrayList;
import java.util.List;

import com.collaborate.model.Blog;
import com.collaborate.model.BlogDto;

public interface BlogService {

	public void addBlog(Blog blog,int blogCategoryId); // insert
	public void addComment(Blog blog,int blogCategoryId); // insert   
	public Blog getBlog(int blogid);  
	   public ArrayList<Blog> getComments(int blogId);
	  // public int countComments(int blogId);
	   public  ArrayList<BlogDto>    getAllBlogs();
	 //  public  List<Blog>    getAllBlogsGroupByTitle();  //  group by title

	   public List<Blog>  showUnApprovedBlogs();
	   public void updateBlog(Blog blog);
	   public List<Blog> showApprovedBlogs();
	   public List<Blog> showRecentBlogs(String p);
}
