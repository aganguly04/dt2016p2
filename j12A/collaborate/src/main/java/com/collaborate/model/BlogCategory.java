package com.collaborate.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
@Entity
public class BlogCategory implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="categoryid")
	private int categoryId;
	private String categoryName;
	
	@Transient
	@OneToMany(mappedBy="blogCategory")
	private Set<Blog> blogs;
	public BlogCategory()
	{
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the blogs
	 */
	public Set<Blog> getBlogs() {
		return blogs;
	}
	/**
	 * @param blogs the blogs to set
	 */
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}
     
	
}
