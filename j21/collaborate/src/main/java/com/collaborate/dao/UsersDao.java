package com.collaborate.dao;

import java.util.List;
import com.collaborate.model.*;


public interface UsersDao {
	public void addUsers(Users users);

	public Users getUsersById(int userId);

	public List<Users> getAllUsers();

	public Users getUsersByUsername(String userName);

}
