package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.model.User;
import com.company.util.DBUtil;
import com.company.dao.UserDAO;

public class UserDAOImplementation implements UserDAO {
	
	public static void main(String[] args) {
		UserDAO userDao = new UserDAOImplementation();
	}
	private Connection conn;

	public UserDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addUser( User user ) {
		try {
			String query = "insert into user (userId, userName,password) values (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt( 1, user.getUserId() );
			preparedStatement.setString( 2, user.getUserName() );
			preparedStatement.setString( 3, user.getPassword() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteUser( int userId ) {
		try {
			String query = "delete from user where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateUser( User user ) {
		try {
			String query = "update user set userName=?, password=? where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt( 1, user.getUserId() );
			preparedStatement.setString( 2, user.getUserName() );
			preparedStatement.setString( 3, user.getPassword() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from user" );
			while( resultSet.next() ) {
				User user = new User();
				user.setUserId( resultSet.getInt( "userId" ) );
				user.setUserName( resultSet.getString( "userName" ) );
				user.setPassword( resultSet.getString( "password" ) );
				users.add(user);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	@Override
	public User getUserById(int userId) {
		User user = new User();
		try {
			String query = "select * from user where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				user.setUserId( resultSet.getInt( "userId" ) );
				user.setUserName( resultSet.getString( "userName" ) );
				user.setPassword( resultSet.getString( "password" ) );
				
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


public boolean validateUser(User user) {
	
	String adminUser = "admin";
	String genUser = "user";
	
			
	// TODO Auto-generated method stub
//	user.getId();
	
	if(user.getUserName().equals(adminUser) && user.getPassword().equals(adminUser)) {
		return true;
	}
	
	if(user.getUserName().equals(genUser) && user.getPassword().equals(genUser)) {
		return true;
	}
	return false;
	
}
@Override
public User getUserByName(String userName) {
	User user = new User();
	try {
		String query = "select * from user where userName=?";
		PreparedStatement preparedStatement = conn.prepareStatement( query );
		preparedStatement.setString(1, userName);
		ResultSet resultSet = preparedStatement.executeQuery();
		while( resultSet.next() ) {
			user.setUserId( resultSet.getInt( "userId" ) );
			user.setUserName( resultSet.getString( "userName" ) );
			user.setPassword( resultSet.getString( "password" ) );
			
		}
		resultSet.close();
		preparedStatement.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
	// TODO Auto-generated method stub
//	return null;
}
}


