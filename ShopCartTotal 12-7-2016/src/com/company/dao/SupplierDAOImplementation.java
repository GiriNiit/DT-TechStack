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
		//	String query = "insert into SUPPLIER (supplierName, supplierAddress, supplierContact, productId, categoryId, categoryName) values (?,?,?,?,?,?)";
			
			String query = "insert into SUPPLIER (supplierName, supplierAddress, supplierContact,  categoryName) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
//			preparedStatement.setInt( 1, supplier.getSupplierId() );
			preparedStatement.setString( 1, supplier.getSupplierName() );
			preparedStatement.setString( 2, supplier.getSupplierAddress() );
			preparedStatement.setInt( 3, supplier.getSupplierContact() );
		//	preparedStatement.setInt( 4, supplier.getProductId() );
		//  preparedStatement.setInt( 5, supplier.getCategoryId() );
			preparedStatement.setString( 4, supplier.getCategoryName() );
       		
			
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
			//String query = "update Supplier set supplierName=?, supplierAddress=?, supplierContact=?, productId=?, categoryId=?, categoryName=?  where supplierId=?";
			String query = "update Supplier set supplierName=?, supplierAddress=?, supplierContact=?,  categoryName=?  where supplierId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, supplier.getSupplierName() );
			preparedStatement.setString( 2, supplier.getSupplierAddress() );
			preparedStatement.setInt( 3, supplier.getSupplierContact() );
		//  preparedStatement.setInt( 4, supplier.getProductId() );
	//		preparedStatement.setInt( 5, supplier.getCategoryId() );
			preparedStatement.setString( 4, supplier.getCategoryName() );
     		preparedStatement.setInt(5, supplier.getSupplierId());
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
				supplier.setSupplierName( resultSet.getString( "supplierName" ) );
				supplier.setSupplierAddress( resultSet.getString( "supplierAddress" ) );
				supplier.setSupplierContact( resultSet.getInt( "SupplierContact" ) );
				supplier.setProductId( resultSet.getInt( "ProductId" ) );
				supplier.setCategoryId( resultSet.getInt( "CategoryId" ) );
				supplier.setCategoryName( resultSet.getString( "CategoryName" ) );
				
				
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
				supplier.setSupplierName( resultSet.getString( "supplierName" ) );
				supplier.setSupplierAddress ( resultSet.getString( "supplierAddress" ) );
				supplier.setSupplierContact( resultSet.getInt( "supplierContact" ) );
				supplier.setProductId( resultSet.getInt( "ProductId" ) );
				supplier.setCategoryId( resultSet.getInt( "CategoryId" ) );
				supplier.setCategoryName( resultSet.getString( "CategoryName" ) );
				
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
