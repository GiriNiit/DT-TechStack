package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import com.company.model.Registera;
import com.company.util.DBUtil;

public class RegisteraDAOImplementation implements RegisteraDAO {
	
	private Connection conn;

	public RegisteraDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addRegistera( Registera registera ){
			try {
			String query = "insert into REGISTER ( firstName, lastName, email, dob, gender) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt( 1, register.getRegisteraId() );
			preparedStatement.setString( 1, registera.getFirstName() );
			preparedStatement.setString( 2, registera.getLastName() );
			preparedStatement.setString( 3, registera.getEmail() );
			preparedStatement.setString( 4, registera.getDob() );
			preparedStatement.setString( 5, registera.getGender() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteRegistera( int RegisterId ) {
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
	public void updateRegistera( Registera registera ) {
		try {
			String query = "update Register set firstName=?, lastName=?, email=?, dob=?, gender=? where registerId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, registera.getFirstName() );
			preparedStatement.setString( 2, registera.getLastName() );
			preparedStatement.setString( 3, registera.getEmail() );
			preparedStatement.setString( 4, registera.getDob() );
			preparedStatement.setString( 5, registera.getGender() );
			preparedStatement.setInt(6, registera.getRegisterId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Registera> getAllRegisteras() {
		List<Registera> registeras = new ArrayList<Registera>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from Register" );
			while( resultSet.next() ) {
				Registera registera = new Registera();
				registera.setRegisterId( resultSet.getInt( "registerId" ) );
				registera.setFirstName( resultSet.getString( "firstName" ) );
				registera.setLastName( resultSet.getString( "lastName" ) );
				registera.setEmail( resultSet.getString( "email" ) );
				registera.setDob( resultSet.getString( "dob" ) );
				registera.setGender( resultSet.getString( "gender" ) );
				registeras.add(registera);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registeras;
	}
	@Override
	public Registera getRegisteraById(int registerId) {
		Registera registera = new Registera();
		try {
			String query = "select * from register where registerId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, registerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				registera.setRegisterId( resultSet.getInt( "registerId" ) );
				registera.setFirstName( resultSet.getString( "firstName" ) );
				registera.setLastName( resultSet.getString( "LastName" ) );
				registera.setEmail( resultSet.getString( "email" ) );
				registera.setDob( resultSet.getString( "dob" ) );
				registera.setGender( resultSet.getString( "gender" ) );

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registera;
	}
	/*@Override
	public List<Registera> getAllRegisteras() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}