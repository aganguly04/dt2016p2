package com.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Forum;

@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}


	@Override
	public List<Forum> showForums() {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Forum");
		List<Forum> forums=q.list();
		return forums;
	}

	@Override
	public void addForum(Forum forum) {
		// TODO Auto-generated method stub
		Session s = getSession();
		s.saveOrUpdate(forum);
		s.flush();
		s.close();
		
	}

}
