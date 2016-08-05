package com.collaborate.model;

import java.io.Serializable;

public class UsersDto implements Serializable {

	private Users users;
	private boolean alreadyFriends;
	private boolean alreadyRequestedByUser;
	private boolean alreadyRequestedByMySelf;
	
	public UsersDto()
	{
		
	}

	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the alreadyFriends
	 */
	public boolean isAlreadyFriends() {
		return alreadyFriends;
	}

	/**
	 * @param alreadyFriends the alreadyFriends to set
	 */
	public void setAlreadyFriends(boolean alreadyFriends) {
		this.alreadyFriends = alreadyFriends;
	}

	/**
	 * @return the alreadyRequestedByUser
	 */
	public boolean isAlreadyRequestedByUser() {
		return alreadyRequestedByUser;
	}

	/**
	 * @param alreadyRequestedByUser the alreadyRequestedByUser to set
	 */
	public void setAlreadyRequestedByUser(boolean alreadyRequestedByUser) {
		this.alreadyRequestedByUser = alreadyRequestedByUser;
	}

	/**
	 * @return the alreadyRequestedByMySelf
	 */
	public boolean isAlreadyRequestedByMySelf() {
		return alreadyRequestedByMySelf;
	}

	/**
	 * @param alreadyRequestedByMySelf the alreadyRequestedByMySelf to set
	 */
	public void setAlreadyRequestedByMySelf(boolean alreadyRequestedByMySelf) {
		this.alreadyRequestedByMySelf = alreadyRequestedByMySelf;
	}

	public UsersDto(Users users, boolean alreadyFriends, boolean alreadyRequestedByUser,
			boolean alreadyRequestedByMySelf) {
		super();
		this.users = users;
		this.alreadyFriends = alreadyFriends;
		this.alreadyRequestedByUser = alreadyRequestedByUser;
		this.alreadyRequestedByMySelf = alreadyRequestedByMySelf;
	}
	
	
	
}
