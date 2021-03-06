package com.collaborate.service;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.dao.PostDao;
import com.collaborate.model.Post;
@Service("postService")
@Transactional
@PersistenceContext
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao  postDao ;
	@Override
	public List<Post> showOriginalPosts(int forumId) {
		// TODO Auto-generated method stub
		return postDao.showOriginalPosts(forumId);
	}

	@Override
	public List<Post> showPosts(int postId) {
		// TODO Auto-generated method stub
		return postDao.showPosts(postId);
	}

	@Override
	public Post showPost(int postId) {
		// TODO Auto-generated method stub
		return postDao.showPost(postId);
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		postDao.addPost(post);
	}

}
