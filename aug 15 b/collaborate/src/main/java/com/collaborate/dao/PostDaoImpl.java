package com.collaborate.dao;

import java.sql.Date;
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
		Query q=s.createQuery("from Post  where forum.forumId = :id and pid = 0 and approved !=0");
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
		
		//Forum f=(Forum)s.get(Forum.class,forumId);  
	//	post.setForum(f);
	//	post.setPid(0);
		s.saveOrUpdate(post);	
		s.flush();
		s.close();
	}
	
	public void addPost(Post post,int forumId)
	{
Session s = getSession();
		
		Forum f=(Forum)s.get(Forum.class,forumId);  
		post.setForum(f);
		post.setPid(0);
		post.setDatePosted(new Date(System.currentTimeMillis()));
		post.setApproved(false);
		s.saveOrUpdate(post);	
		s.flush();
		s.close();
	}
	
	
	public void updatePost(Post post)
	 {
		 //Transaction tx = getSession().beginTransaction();
		 Session s=getSession();
		 
		 
		 s.update(post);
		 s.flush();
		 s.close();
		// tx.commit();
	 }
	
	
	@Override
	public List<Post> showUnApprovedPosts() {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Post where approved = 0  and pid=0");
		List<Post> posts=q.list();
		return posts;
	} 
	
	
	

}

