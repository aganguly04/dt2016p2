package com.collaborate.service;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.dao.UsersDao;
import com.collaborate.model.Users;

@Service("usersService")
@Transactional
@PersistenceContext
public class UsersServiceImpl implements UsersService {
	@Autowired
    
    UsersDao usersDao;
    
    
	
	
	@Transactional
	public void addUsers(Users users) {
		// TODO Auto-generated method stub
		usersDao.addUsers(users);
	}

	public Users getUsersById(int userId) {
		// TODO Auto-generated method stub
		return usersDao.getUsersById(userId);
	}

	public List<Users> getAllUsers(String un) {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers(un);
	}

	public Users getUsersByUsername(String userName) {
		// TODO Auto-generated method stub
		return usersDao.getUsersByUsername(userName);
	}
	public void editUsers(Users users)
	{
		usersDao.editUsers(users);
	}

}
