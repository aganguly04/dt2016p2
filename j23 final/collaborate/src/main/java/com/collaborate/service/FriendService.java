
package com.collaborate.service;
import java.util.List;

import com.collaborate.model.Friend;

public interface FriendService {

	public void  addFriend(Friend friend);
	public int unFriend(String mySelf,String user);
	public List<Friend> showFriends(String mySelf);
	public boolean isFriends(String mySelf,String user);
	public void acceptFriend(String user,String myself);
}
