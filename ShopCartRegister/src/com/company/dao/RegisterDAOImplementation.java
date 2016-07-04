package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import com.company.model.Register;
import com.company.util.DBUtil;

public class RegisterDAOImplementation implements RegisterDAO {
	
	private Connection conn;

	public RegisterDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addRegister( Register register ) {
		try {
			String query = "insert into REGISTER ( firstName, lastName, email, dob, gender) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt( 1, register.getRegisterId() );
			preparedStatement.setString( 1, register.getFirstName() );
			preparedStatement.setString( 2, register.getLastName() );
			preparedStatement.setString( 3, register.getEmail() );
			preparedStatement.setString( 4, register.getDob() );
			preparedStatement.setString( 5, register.getGender() );
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
	public void updateRegister( Register register ) {
		try {
			String query = "update Register set firstName=?, lastName=?, email=?, dob=?, gender=? where registerId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, register.getFirstName() );
			preparedStatement.setString( 2, register.getLastName() );
			preparedStatement.setString( 3, register.getEmail() );
			preparedStatement.setString( 4, register.getDob() );
			preparedStatement.setString( 5, register.getGender() );
			preparedStatement.setInt(6, register.getRegisterId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Register> getAllRegisters() {
		List<Register> registers = new ArrayList<Register>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from Register" );
			while( resultSet.next() ) {
				Register register = new Register();
				register.setRegisterId( resultSet.getInt( "registerId" ) );
				register.setFirstName( resultSet.getString( "firstName" ) );
				register.setLastName( resultSet.getString( "lastName" ) );
				register.setEmail( resultSet.getString( "email" ) );
				register.setDob( resultSet.getString( "dob" ) );
				register.setGender( resultSet.getString( "gender" ) );
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
	public Register getRegisterById(int registerId) {
		Register register = new Register();
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

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return register;
	}
	/*@Override
	public List<Register> getAllRegisters() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}