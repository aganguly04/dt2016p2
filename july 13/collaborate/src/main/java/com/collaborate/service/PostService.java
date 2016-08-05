package com.collaborate.service;

import java.util.List;

import com.collaborate.model.Post;

public interface PostService {
	public List<Post>  showOriginalPosts(int forumId);
	public List<Post>  showPosts(int postId);
	public Post  showPost(int postId);
	public void addPost(Post post);
	public void addPost(Post post,int forumId);
}
