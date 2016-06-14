package com.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Friend;
import com.collaborate.model.FriendRequest;
@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}


	@Override
	public void addFriend(Friend friend) {
		// TODO Auto-generated method stub
		Session s = getSession();
		s.saveOrUpdate(friend);
		s.flush();
		s.close();
	}

	@Override
	public int unFriend(String mySelf, String user) {
		// TODO Auto-generated method stub

		Session s = getSession();
		Query query=s.createQuery("delete from Friend where ( userone = :myself1 and usertwo = :user1 ) or ( userone = :user2 and usertwo = :myself2 )");
		
		query.setParameter("myself1",mySelf);
		query.setParameter("myself2",mySelf);
		query.setParameter("user1",user);
		query.setParameter("user2",user);
		int rowsDeleted=query.executeUpdate();
		return rowsDeleted;
		
		
		
		
		
		
	}

	@Override
	public List<Friend> showFriends(String mySelf) {
		// TODO Auto-generated method stub
		String hql = "from Friend where userone = :mySelf1 or usertwo = :mySelf2";
		Session s = getSession();
		
		Query query = s.createQuery(hql);
		query.setParameter("mySelf1",mySelf);
		query.setParameter("mySelf2",mySelf);
		List<Friend> list = query.list();		
		return list;
	}

	@Override
	public boolean isFriends(String mySelf, String user) {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query query=s.createQuery("from Friend where ( userone = :myself1 and usertwo = :user1 ) or ( userone = :user2 and usertwo = :myself2 )");
		
		query.setParameter("myself1",mySelf);
		query.setParameter("myself2",mySelf);
		query.setParameter("user1",user);
		query.setParameter("user2",user);
		List list=query.list();
		
		if (list.size()==1)
			return true;
		else
			return false;
		
	}

}
