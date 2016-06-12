package com.collaborate.model;

import java.io.Serializable;
import java.sql.Date;

public class BlogDto implements Serializable {

	
	private int blogId;
	private String name;
	private String title;
	private String comment;
	private Date datePosted;
	private int blogChildId;
	private String blogCategory;
	/**
	 * @return the blogId
	 */
	public int getBlogId() {
		return blogId;
	}
	/**
	 * @param blogId the blogId to set
	 */
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the datePosted
	 */
	public Date getDatePosted() {
		return datePosted;
	}
	/**
	 * @param datePosted the datePosted to set
	 */
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	/**
	 * @return the blogChildId
	 */
	public int getBlogChildId() {
		return blogChildId;
	}
	/**
	 * @param blogChildId the blogChildId to set
	 */
	public void setBlogChildId(int blogChildId) {
		this.blogChildId = blogChildId;
	}
	/**
	 * @return the blogCategory
	 */
	public String getBlogCategory() {
		return blogCategory;
	}
	/**
	 * @param blogCategory the blogCategory to set
	 */
	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}
	public BlogDto(int blogId, String name, String title, String comment, Date datePosted, int blogChildId,
			String blogCategory) {
		super();
		this.blogId = blogId;
		this.name = name;
		this.title = title;
		this.comment = comment;
		this.datePosted = datePosted;
		this.blogChildId = blogChildId;
		this.blogCategory = blogCategory;
	}
	public BlogDto()
	{
		
	}
	
	
}
