package com.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Forum;
import com.collaborate.model.Post;

@Repository("postDao")
public class PostDaoImpl implements PostDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}


	@Override
	public List<Post> showOriginalPosts(int forumId) {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Post  where forum.forumId = :id and pid = 0");
		q.setParameter("id",forumId);
		List<Post> posts=q.list();
		return posts;

	}

	@Override
	public List<Post> showPosts(int postId) {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Post  where pid = :id ");
		q.setParameter("id",postId);
		List<Post> posts=q.list();
		return posts;
	}

	@Override
	public Post showPost(int postId) {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Post  where postId = :id ");
		q.setParameter("id",postId);
		Object queryResult = q.uniqueResult();
			Post post = (Post)queryResult;
		return post ;
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		Session s = getSession();
		s.saveOrUpdate(post);	
		s.flush();
		s.close();
	}

}

