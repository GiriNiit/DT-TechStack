package com.niit.ShoppingCart.dao.Implem;

import java.util.ArrayList;
import java.util.List;

import com.niit.ShoppingCart.dao.UserDao;
import com.niit.ShoppingCart.model.User;

public class UserDaoImpl implements UserDao {

	//list is working as a database
	   List<User> users;

	   public UserDaoImpl(){
	      users = new ArrayList<User>();
	      User user1 = new User("Varun",0,"pass");
	      User user2 = new User("Raj",1,"pass");
	      User user3 = new User("Suraj",2,"pass");
	      User user4 = new User("Surya",3,"pass");
	      User user5 = new User("Sudeep",4,"pass");
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
}
