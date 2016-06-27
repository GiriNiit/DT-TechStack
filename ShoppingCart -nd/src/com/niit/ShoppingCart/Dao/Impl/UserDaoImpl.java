package com.niit.ShoppingCart.NoDB.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.niit.ShoppingCart.NoDB.Dao.UserDao;
import com.niit.ShoppingCart.NoDB.Model.User;

public class UserDaoImpl implements UserDao {

	//list is working as a database
	   List<User> users;

	   public UserDaoImpl(){
	      users = new ArrayList<User>();
	      User user1 = new User("Varun","pass");
	      User user2 = new User("Raj","pass");
	      User user3 = new User("Suraj","pass");
	      User user4 = new User("Surya","pass");
	      User user5 = new User("Sudeep","pass");
	      users.add(user1);
	      users.add(user2);	
	      users.add(user3);
	      users.add(user4);
	      users.add(user5);
	   }
	   
	   @Override
	   public void deleteUser(User user) {
	      users.remove(user.getId());
	      System.out.println("User: Id " + user.getId() + ", deleted from database");
	   }

	   //retrieve list of users from the database
	   @Override
	   public List<User> getAllUsers() {
	      return users;
	   }

	   @Override
	   public User getUser(int rollNo) {
	      return users.get(rollNo);
	   }

	   @Override
	   public void updateUser(User user) {
	      users.get(user.getId()).setName(user.getName());
	      System.out.println("User: Id " + user.getId() + ", updated in the database");
	   }

	@Override
	public boolean validateUser(User user) {
		
		String adminUser = "admin";
		String genUser = "user";
		
				
		// TODO Auto-generated method stub
//		user.getId();
		
		if(user.getName().equals(adminUser) && user.getPassword().equals(adminUser)) {
			return true;
		}
		
		if(user.getName().equals(genUser) && user.getPassword().equals(genUser)) {
			return true;
		}
		return false;
		
	}
}
