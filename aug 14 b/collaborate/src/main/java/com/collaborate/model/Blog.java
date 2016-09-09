package com.collaborate.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Blog implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="blogid")
	private int blogId;
	private String name;
	private String title;
	private String owner;
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	private String comment;
	@Column(nullable=true)
	private boolean approved;
	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	private Date datePosted;
	private int blogChildId;

	@ManyToOne
	@JoinColumn(name="categoryid")
	@JsonIgnore
	private BlogCategory blogCategory;
	public Blog()
	{
	}
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
	public BlogCategory getBlogCategory() {
		return blogCategory;
	}
	/**
	 * @param blogCategory the blogCategory to set
	 */
	public void setBlogCategory(BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", name=" + name + ", title=" + title
				+ ", comment=" + comment + ", datePosted=" + datePosted + "]";
	}
	
}
