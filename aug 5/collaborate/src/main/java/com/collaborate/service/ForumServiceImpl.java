package com.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.dao.ForumDao;
import com.collaborate.model.Forum;
@Service("forumService")
@Transactional
public class ForumServiceImpl implements ForumService {
	@Autowired
	ForumDao  forumDao ;
	@Override
	public List<Forum> showForums() {
		// TODO Auto-generated method stub
		return forumDao.showForums() ;
	}

	@Override
	public void addForum(Forum forum) {
		// TODO Auto-generated method stub
		forumDao.addForum(forum);			
	}

}
