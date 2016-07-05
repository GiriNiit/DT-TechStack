package com.company.dao;

import java.util.List;
import java.sql.Date;

import com.company.model.User1;

public interface User1DAO {
	public void addUser1( User1 user1 );
	public void deleteUser1( int userId );
	public void updateUser1( User1 user1 );
	public List<User1> getAllUser1s();
	public User1 getUser1ById( int userId );
//	List<User1> getAllUser1s();
}