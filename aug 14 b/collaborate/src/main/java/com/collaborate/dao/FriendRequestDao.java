package com.collaborate.dao;

import java.util.List;

import com.collaborate.model.FriendRequest;

public interface FriendRequestDao {

	public void sendFriendRequest(FriendRequest friendRequest);
	public int cancelFriendRequest(String fromUserName,String toUserName);
	public void acceptFriendRequest(String fromUserName,String mySelf);
	public List<FriendRequest> showFriendRequests(String mySelf);
	public int  friendRequestStatus(String from , String to);
}
