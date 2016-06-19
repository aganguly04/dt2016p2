package com.collaborate.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommentDto implements Serializable {

	private Blog blog;
	private ArrayList<Blog> comments;
	public CommentDto()
	{
		
	}
	/**
	 * @return the blog
	 */
	public Blog getBlog() {
		return blog;
	}
	/**
	 * @param blog the blog to set
	 */
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	/**
	 * @return the comments
	 */
	public ArrayList<Blog> getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(ArrayList<Blog> comments) {
		this.comments = comments;
	}
	
	
}
