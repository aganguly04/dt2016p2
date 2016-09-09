package com.collaborate.dao;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Blog;
import com.collaborate.model.Forum;


@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private FriendDao friendDao;
	
	/**
	 * @param friendDao the friendDao to set
	 */
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

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
		forum.setApproved(false);
		forum.setDatePosted(new Date(System.currentTimeMillis()));
		s.saveOrUpdate(forum);
		s.flush();
		s.close();
		
	}

	@Override
	public List<Forum> showUnApprovedForums() {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Forum where approved = 0");
		List<Forum> forums=q.list();
		return forums;
	}
	@Override
	public List<Forum> showApprovedForums() {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Forum where approved != 0");
		List<Forum> forums=q.list();
		return forums;
	}
	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		
		Session s = getSession();
		Forum f = (Forum) s.get(Forum.class, forumId);
		System.out.println(f);
		return f;
		
	}
	public void updateForum(Forum forum)
	 {
		 //Transaction tx = getSession().beginTransaction();
		 Session s=getSession();
		 
		 
		 s.update(forum);
		 s.flush();
		 s.close();
		// tx.commit();
	 }

	@Override
	public List<Forum> showForums(String p) {
		// TODO Auto-generated method stub
		
		String mySelf=p;
		List<Forum> allForums=showApprovedForums();
		List<Forum> forums=new ArrayList<Forum>();
		for (Forum f:allForums)
		{
			String owner=f.getOwner();
			if (friendDao.isFriends(mySelf, owner))
			{
				forums.add(f);
			}
			if (mySelf.compareTo(owner)==0)
			{
				forums.add(f);
			}
			
		}
		return forums;
	}

}
