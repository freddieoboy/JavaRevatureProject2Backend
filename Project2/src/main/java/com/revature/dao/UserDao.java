package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public List<User> getUsers();
	
	public User getUserById(int id);
	
	public User getUserByEmailAndPassword(String e, String p);
	public User getUserByUsernameAndPassword(String u, String p);
	
	public int createUser(User u);
	public void updateUser(User u);
	
	public void deleteUserById(int id);

}
