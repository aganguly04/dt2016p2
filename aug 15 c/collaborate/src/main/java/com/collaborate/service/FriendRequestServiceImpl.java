package com.collaborate.service;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.dao.FriendRequestDao;
import com.collaborate.dao.UsersDao;
import com.collaborate.model.FriendRequest;
@Service("friendRequestService")
@Transactional
@PersistenceContext
public class FriendRequestServiceImpl  implements FriendRequestService{
@Autowired
    
    FriendRequestDao friendRequestDao;
	@Override
	public void sendFriendRequest(FriendRequest friendRequest) {
		// TODO Auto-generated method stub
		friendRequestDao.sendFriendRequest(friendRequest);
	}

	@Override
	public int cancelFriendRequest(String fromUserName, String toUserName) {
		// TODO Auto-generated method stub
		return friendRequestDao.cancelFriendRequest(fromUserName, toUserName);
	}

	@Override
	public void acceptFriendRequest(String fromUserName, String mySelf) {
		// TODO Auto-generated method stub
		friendRequestDao.acceptFriendRequest(fromUserName, mySelf);
		
	}

	@Override
	public List<FriendRequest> showFriendRequests(String mySelf) {
		// TODO Auto-generated method stub
		return friendRequestDao.showFriendRequests(mySelf);
	}

	@Override
	public int friendRequestStatus(String from, String to) {
		// TODO Auto-generated method stub
		return friendRequestDao.friendRequestStatus(from, to);
	}

}
