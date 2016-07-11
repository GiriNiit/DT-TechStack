package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import com.company.model.UserRegister;
import com.company.util.DBUtil;

public class UserRegisterDAOImplementation implements UserRegisterDAO {
	
	private Connection conn;

	public UserRegisterDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addRegister( UserRegister register ){
			try {
			String query = "insert into REGISTER ( firstName, lastName, email, dob, gender, requestaccess) values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt( 1, register.getRegisteraId() );
			preparedStatement.setString( 1, register.getFirstName() );
			preparedStatement.setString( 2, register.getLastName() );
			preparedStatement.setString( 3, register.getEmail() );
			preparedStatement.setString( 4, register.getDob() );
			preparedStatement.setString( 5, register.getGender() );
			preparedStatement.setString( 6, register.getRequestaccess() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteRegister( int RegisterId ) {
		try {
			String query = "delete from Register where registerId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, RegisterId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateRegister( UserRegister register ) {
		try {
			String query = "update Register set firstName=?, lastName=?, email=?, dob=?, gender=?, requestaccess=? where registerId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, register.getFirstName() );
			preparedStatement.setString( 2, register.getLastName() );
			preparedStatement.setString( 3, register.getEmail() );
			preparedStatement.setString( 4, register.getDob() );
			preparedStatement.setString( 5, register.getGender() );
			preparedStatement.setString( 6, register.getRequestaccess() );
			preparedStatement.setInt(7, register.getRegisterId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<UserRegister> getAllRegisters() {
		List<UserRegister> registers = new ArrayList<UserRegister>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from Register" );
			while( resultSet.next() ) {
				UserRegister register = new UserRegister();
				register.setRegisterId( resultSet.getInt( "registerId" ) );
				register.setFirstName( resultSet.getString( "firstName" ) );
				register.setLastName( resultSet.getString( "lastName" ) );
				register.setEmail( resultSet.getString( "email" ) );
				register.setDob( resultSet.getString( "dob" ) );
				register.setGender( resultSet.getString( "gender" ) );
				register.setRequestaccess( resultSet.getString( "requestaccess" ) );
				registers.add(register);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registers;
	}
	@Override
	public UserRegister getRegisterById(int registerId) {
		UserRegister register = new UserRegister();
		try {
			String query = "select * from register where registerId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, registerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				register.setRegisterId( resultSet.getInt( "registerId" ) );
				register.setFirstName( resultSet.getString( "firstName" ) );
				register.setLastName( resultSet.getString( "LastName" ) );
				register.setEmail( resultSet.getString( "email" ) );
				register.setDob( resultSet.getString( "dob" ) );
				register.setGender( resultSet.getString( "gender" ) );
				register.setRequestaccess( resultSet.getString( "requestaccess" ) );

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return register;
	}
	/*@Override
	public List<Registera> getAllRegisteras() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}