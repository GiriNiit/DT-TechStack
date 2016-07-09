package com.company.dao;

import java.util.List;
import java.sql.Date;

import com.company.model.AdminAddUser;

public interface AdminAddUserDAO {
	public void addUser( AdminAddUser user );
	public void deleteUser( int userId );
	public void updateUser( AdminAddUser user );
	public List<AdminAddUser> getAllUsers();
	public AdminAddUser getUserById( int userId );
//	List<User1> getAllUser1s();
}