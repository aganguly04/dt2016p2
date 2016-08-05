package com.collaborate.service;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.dao.FriendDao;
import com.collaborate.dao.UsersDao;
import com.collaborate.model.Friend;
@Service("friendService")
@Transactional
@PersistenceContext
public class FriendServiceImpl implements FriendService {
@Autowired
    
    FriendDao friendDao;
    
	@Override
	public void addFriend(Friend friend) {
		// TODO Auto-generated method stub
		friendDao.addFriend(friend);
	}

	@Override
	public int unFriend(String mySelf, String user) {
		// TODO Auto-generated method stub
		return friendDao.unFriend(mySelf, user);
	}

	@Override
	public List<Friend> showFriends(String mySelf) {
		// TODO Auto-generated method stub
		return friendDao.showFriends(mySelf);
	}

	@Override
	public boolean isFriends(String mySelf, String user) {
		// TODO Auto-generated method stub
		return friendDao.isFriends(mySelf, user);
	}
	
	public void acceptFriend(String user,String myself)
	{
		friendDao.acceptFriend(user, myself);
	}

}
