package com.company.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Category;
import com.company.util.DBUtil;

public class CategoryDAOImplementation implements CategoryDAO {
	
	private Connection conn;

	public CategoryDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addCategory( Category category ) {
		try {
			String query = "insert into CATEGORY ( categoryName, categoryDescription, productId, supplierId) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt( 1, category.getCategoryId() );
			preparedStatement.setString( 1, category.getCategoryName() );
			preparedStatement.setString( 2, category.getCategoryDescription() );
			preparedStatement.setInt( 3, category.getProductId() );
			preparedStatement.setInt( 4, category.getSupplierId() );
			
						
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteCategory( int CategoryId ) {
		try {
			String query = "delete from Category where categoryId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, CategoryId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateCategory( Category category ) {
		try {
			String query = "update Category set categoryName=?, categoryDescription=?, productId=?, supplierId=? where categoryId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, category.getCategoryName() );
			preparedStatement.setString( 2, category.getCategoryDescription() );
			preparedStatement.setInt(3, category.getProductId());
			preparedStatement.setInt(4, category.getSupplierId());
			preparedStatement.setInt(5, category.getCategoryId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Category> getAllCategorys() {
		List<Category> categorys = new ArrayList<Category>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from Category" );
			while( resultSet.next() ) {
				Category category = new Category();
				category.setCategoryId( resultSet.getInt( "categoryId" ) );
				category.setCategoryName( resultSet.getString( "categoryName" ) );
				category.setCategoryDescription( resultSet.getString( "categoryDescription" ) );
				category.setProductId( resultSet.getInt( "productId" ) );
				category.setSupplierId( resultSet.getInt( "supplierId" ) );
				
				categorys.add(category);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorys;
	}
	@Override
	public Category getCategoryById(int categoryId) {
		Category category = new Category();
		try {
			String query = "select * from category where categoryId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, categoryId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				category.setCategoryId( resultSet.getInt( "categoryId" ) );
				category.setCategoryName( resultSet.getString( "categoryName" ) );
				category.setCategoryDescription( resultSet.getString( "categoryDescription" ) );
				category.setProductId( resultSet.getInt( "productId" ) );
				category.setSupplierId( resultSet.getInt( "supplierId" ) );
							}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
	@Override
	public List<Category> getAllCategoryss() {
		// TODO Auto-generated method stub
		return null;
	}
}
