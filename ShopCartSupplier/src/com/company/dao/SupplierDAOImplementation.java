package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Supplier;
import com.company.util.DBUtil;

public class SupplierDAOImplementation implements SupplierDAO {
	
	private Connection conn;

	public SupplierDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addSupplier( Supplier supplier ) {
		try {
			String query = "insert into SUPPLIER (supName, supAddress) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
//			preparedStatement.setInt( 1, supplier.getSupplierId() );
			preparedStatement.setString( 1, supplier.getSupName() );
			preparedStatement.setString( 2, supplier.getSupAddress() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteSupplier( int SupplierId ) {
		try {
			String query = "delete from Supplier where supplierId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, SupplierId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateSupplier( Supplier supplier ) {
		try {
			String query = "update Supplier set supName=?, supAddress=?  where supplierId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, supplier.getSupName() );
			preparedStatement.setString( 2, supplier.getSupAddress() );
			preparedStatement.setInt(3, supplier.getSupplierId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from Supplier" );
			while( resultSet.next() ) {
				Supplier supplier = new Supplier();
				supplier.setSupplierId( resultSet.getInt( "supplierId" ) );
				supplier.setSupName( resultSet.getString( "supName" ) );
				supplier.setSupAddress( resultSet.getString( "supAddress" ) );
				
				suppliers.add(supplier);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suppliers;
	}
	@Override
	public Supplier getSupplierById(int supplierId) {
		Supplier supplier = new Supplier();
		try {
			String query = "select * from supplier where supplierId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, supplierId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				supplier.setSupplierId( resultSet.getInt( "supplierId" ) );
				supplier.setSupName( resultSet.getString( "supName" ) );
				supplier.setSupAddress ( resultSet.getString( "supAddress" ) );
							}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplier;
	}
	@Override
	public List<Supplier> getAllSupplierss() {
		// TODO Auto-generated method stub
		return null;
	}
}
