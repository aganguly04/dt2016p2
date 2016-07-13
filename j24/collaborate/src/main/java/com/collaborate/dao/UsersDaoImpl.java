package com.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.model.UserRoles;
import com.collaborate.model.Users;


@Repository("usersDao")
@Transactional
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void addUsers(Users users) {
		// TODO Auto-generated method stub

		Session session = getSession();

		String s = users.getUserName();

		users.setEnabled(true);

		UserRoles ur = new UserRoles();
		ur.setRoleName("USER");
		ur.setUserName(s);
		session.save(ur);
		session.save(users);

		session.flush();

		session.close();

	}

	public Users getUsersById(int userId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		return (Users) session.get(Users.class, userId);
	}

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Users");
		List<Users> customerList = query.list();

		return customerList;

	}

	public Users getUsersByUsername(String userName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Users where username = ?");
		query.setString(0, userName);

		return (Users) query.uniqueResult();

	}

	
	public void editUsers(Users users)
	 {
		 //Transaction tx = getSession().beginTransaction();
		 Session s=getSession();
		 
		 users.setEnabled(true);
		 s.update(users);
		 s.flush();
		 s.close();
		// tx.commit();
	 }
	
}
