package com.collaborate.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.FriendRequest;
@Repository("friendRequestDao")
public class FriendRequestDaoImpl implements FriendRequestDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}


	@Override
	public void sendFriendRequest(FriendRequest friendRequest) {
		// TODO Auto-generated method stub
		Session s = getSession();
		s.saveOrUpdate(friendRequest);
		s.flush();
		s.close();
	}

	@Override
	public int cancelFriendRequest(String fromUserName, String toUserName) {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query query=s.createQuery("delete from FriendRequest where fromUserName = :fromUserName and toUserName = :toUserName");
		
		query.setParameter("fromUserName",fromUserName);
		query.setParameter("toUserName",toUserName);
		int rowsDeleted=query.executeUpdate();
		return rowsDeleted;
		
	}

	@Override
	public void acceptFriendRequest(String fromUserName, String mySelf) {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query query=s.createQuery("delete from FriendRequest where fromUserName = :fromUserName and toUserName = :myself");
		
		query.setParameter("fromUserName",fromUserName);
		query.setParameter("myself",mySelf);
		int rowsDeleted=query.executeUpdate();
		
		
	}

	@Override
	public List<FriendRequest> showFriendRequests(String mySelf) {
		// TODO Auto-generated method stub
		String hql = "from FriendRequest where toUserName = :mySelf";
		Session s = getSession();
		
		Query query = s.createQuery(hql);
		query.setParameter("mySelf",mySelf);
		List<FriendRequest> list = query.list();		
		return list;
	}

	public int  friendRequestStatus(String from , String to)
	{
		Session s = getSession();
		Query query=s.createQuery("from FriendRequest where fromUserName = :fromUserName and toUserName = :toUserName");
		
		query.setParameter("fromUserName",from);
		query.setParameter("toUserName",to);
		List list=query.list();
		
		return list.size();
		
	}
	
	
}
