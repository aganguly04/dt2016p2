package com.collaborate.service;

import java.util.List;

import com.collaborate.model.Users;

public interface UsersService {
	
	public void addUsers(Users users);

	public Users getUsersById(int userId);

	public List<Users> getAllUsers(String un);

	public Users getUsersByUsername(String userName);

	public void editUsers(Users users);
}
