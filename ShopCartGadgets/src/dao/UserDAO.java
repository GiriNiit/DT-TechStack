package com.company.dao;


import java.util.List;

import com.company.model.User;

public interface UserDAO {
	public void addUser( User user );
	public void deleteUser( int userId );
	public void updateUser( User user );
	public List<User> getAllUsers();
	public User getUserById( int userId );
	public User getUserByName(String userName);
}
