package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Product;
import com.company.util.DBUtil;

public class ProductDAOImplementation implements ProductDAO {
	
	private Connection conn;

	public ProductDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addProduct( Product product ) {
		try {
			String query = "insert into PRODUCT (proName, proDescription, proPrice, proQuantity) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt( 1, product.getProductId() );
			preparedStatement.setString( 1, product.getProName() );
			preparedStatement.setString( 2, product.getProDescription() );
			preparedStatement.setInt( 3, product.getProPrice() );
			preparedStatement.setInt( 4, product.getProQuantity() );
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteProduct( int ProductId ) {
		try {
			String query = "delete from Product where productId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, ProductId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateProduct( Product product ) {
		try {
			String query = "update Product set proName=?, proDescription=?, proPrice=?, proQuantity=?  where productId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, product.getProName() );
			preparedStatement.setString( 2, product.getProDescription() );
			preparedStatement.setInt( 3, product.getProPrice() );
			preparedStatement.setInt( 4, product.getProQuantity() );
			preparedStatement.setInt(5, product.getProductId() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from Product" );
			while( resultSet.next() ) {
				Product product = new Product();
				product.setProductId( resultSet.getInt( "productId" ) );
				product.setProName( resultSet.getString( "proName" ) );
				product.setProDescription( resultSet.getString( "proDescription" ) );
				product.setProPrice( resultSet.getInt( "proPrice" ) );
				product.setProQuantity( resultSet.getInt( "proQuantity" ) );
				products.add(product);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public Product getProductById(int productId) {
		Product product = new Product();
		try {
			String query = "select * from product where productId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				product.setProductId( resultSet.getInt( "productId" ) );
				product.setProName( resultSet.getString( "proName" ) );
				product.setProDescription( resultSet.getString( "proDescription" ) );
				product.setProPrice( resultSet.getInt( "proPrice" ) );
				product.setProQuantity( resultSet.getInt( "proQuantity" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public List<Product> getAllProductss() {
		// TODO Auto-generated method stub
		return null;
	}

}