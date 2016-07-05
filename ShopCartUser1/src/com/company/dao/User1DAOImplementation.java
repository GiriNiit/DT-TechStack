package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.model.User1;
import com.company.util.DBUtil;

public class User1DAOImplementation implements User1DAO {
	
	private Connection conn;

	public User1DAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addUser1( User1 user1 ) {
		try {
			String query = "insert into User ( userName, password) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt( 1, user1.getUser1Id() );
			preparedStatement.setString( 1, user1.getUserName() );
			preparedStatement.setString( 2, user1.getPassword() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteUser1( int UserId ) {
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
	public void updateUser1( User1 user1 ) {
		try {
			String query = "update User set userName=?, password=? where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, user1.getUserName() );
			preparedStatement.setString( 2, user1.getPassword() );
			preparedStatement.setInt(3, user1.getUserId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<User1> getAllUser1s() {
		List<User1> user1s = new ArrayList<User1>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from User" );
			while( resultSet.next() ) {
				User1 user1 = new User1();
				user1.setUserId( resultSet.getInt( "userId" ) );
				user1.setUserName( resultSet.getString( "userName" ) );
				user1.setPassword( resultSet.getString( "password" ) );
				
				user1s.add(user1);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1s;
	}
	@Override
	public User1 getUser1ById(int userId) {
		User1 user1 = new User1();
		try {
			String query = "select * from user where userId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				user1.setUserId( resultSet.getInt( "userId" ) );
				user1.setUserName( resultSet.getString( "userName" ) );
				user1.setPassword( resultSet.getString( "password" ) );
				

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}
	/*@Override
	public List<User1> getAllUser1s() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}