package com.niit.dao;

import com.niit.model.User;

public interface UserDao 
{
	public boolean addUsers(User user);
	public User getUser(int id);
	public boolean updateUser(User user);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);

}
