package com.collaborate.service;

import java.util.List;

import com.collaborate.model.Forum;

public interface ForumService {

	public List<Forum>  showForums();
	  public void addForum(Forum forum);	
}
