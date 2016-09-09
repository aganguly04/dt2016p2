package com.collaborate.dao;

import java.security.Principal;
import java.util.List;

import com.collaborate.model.Forum;

public interface ForumDao {

	public List<Forum>  showForums();
	public List<Forum>  showForums(String p);
	  public void addForum(Forum forum);
	  public List<Forum>  showUnApprovedForums();
	  public Forum getForum(int forumId);
	  public void updateForum(Forum forum);
}
