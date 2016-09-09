package com.collaborate.dao;

import java.util.List;
import java.security.Principal;

import com.collaborate.model.Blog;
import com.collaborate.model.Forum;

public interface BlogDao {

	public void addBlog(Blog blog,int blogCategoryId); // insert
	public void addComment(Blog blog,int blogCategoryId); // insert
	   public Blog getBlog(int blogid);  
	   public List<Blog> getComments(int blogId);
	  // public int countComments(int blogId);
	   public  List<Object[]>    getAllBlogs();
	 //  public  List<Blog>    getAllBlogsGroupByTitle();  //  group by title

	   public List<Blog>  showUnApprovedBlogs();
	   public void updateBlog(Blog blog);
	   public List<Blog> showApprovedBlogs();
	   public List<Blog> showRecentBlogs(String p);
	
}
