package com.collaborate.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity

public class Forum implements Serializable{

	@Id
	@GeneratedValue 
	@Column(name="forumid")
	private int forumId;
	private String name;
	private String description;
	private String owner;
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

	@Transient
	@OneToMany(mappedBy="forum")
	private Set<Post> posts;

	/**
	 * @return the forumId
	 */
	public int getForumId() {
		return forumId;
	}

	/**
	 * @param forumId the forumId to set
	 */
	public void setForumId(int forumId) {
		this.forumId = forumId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

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

	/**
	 * @return the posts
	 */
	public Set<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	
	public Forum()
	{
		
	}

	public Forum(int forumId, String name, String description, String owner, Set<Post> posts) {
		super();
		this.forumId = forumId;
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.posts = posts;
	}

	
	@Override
	public String toString() {
		return "Forum [forumId=" + forumId + ", name=" + name + ", description=" + description
				+ ", owner=" + owner + "]";
	}

}
