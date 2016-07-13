package com.collaborate.dao;

import java.util.List;

import com.collaborate.model.Forum;

public interface ForumDao {

	public List<Forum>  showForums();
	  public void addForum(Forum forum);	
}
