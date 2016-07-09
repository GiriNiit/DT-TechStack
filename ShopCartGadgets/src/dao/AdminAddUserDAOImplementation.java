package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.model.AdminAddUser;
import com.company.util.DBUtil;

public class AdminAddUserDAOImplementation implements AdminAddUserDAO {
	
	private Connection conn;

	public AdminAddUserDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addUser( AdminAddUser user ) {
		try {
			String query = "insert into User ( userName, password, role) values (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt( 1, user1.getUser1Id() );
			preparedStatement.setString( 1, user.getUserName() );
			preparedStatement.setString( 2, user.getPassword() );
			preparedStatement.setString( 3, user.getRole() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteUser( int UserId ) {
		try {
			String query = "delete from User where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, UserId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateUser( AdminAddUser user ) {
		try {
			String query = "update User set userName=?, password=? role=? where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, user.getUserName() );
			preparedStatement.setString( 2, user.getPassword() );
			preparedStatement.setString( 3, user.getRole() );
			preparedStatement.setInt(4, user.getUserId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<AdminAddUser> getAllUsers() {
		List<AdminAddUser> users = new ArrayList<AdminAddUser>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from User" );
			while( resultSet.next() ) {
				AdminAddUser user = new AdminAddUser();
				user.setUserId( resultSet.getInt( "userId" ) );
				user.setUserName( resultSet.getString( "userName" ) );
				user.setPassword( resultSet.getString( "password" ) );
				user.setRole( resultSet.getString( "role" ) );
				
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
	public AdminAddUser getUserById(int userId) {
		AdminAddUser user = new AdminAddUser();
		try {
			String query = "select * from user where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				user.setUserId( resultSet.getInt( "userId" ) );
				user.setUserName( resultSet.getString( "userName" ) );
				user.setPassword( resultSet.getString( "password" ) );
				user.setRole( resultSet.getString( "role" ) );

				

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	/*@Override
	public List<User1> getAllUser1s() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}