package com.niit.ShoppingCart.NoDB.Model;

import java.nio.file.attribute.UserPrincipalLookupService;

import com.niit.ShoppingCart.NoDB.Dao.UserDao;
import com.niit.ShoppingCart.NoDB.Dao.Impl.UserDaoImpl;
import com.niit.ShoppingCart.NoDB.Model.User;

public class TestDaoDemo {
	
	public static void main(String[] args) {
		
	      UserDao userDao = new UserDaoImpl();

	      //print all users
	      for (User user : userDao.getAllUsers()) {
	         System.out.println("user: [Id : " + user.getId() + ", Name : " + user.getName() + " , "
	         		+ "Password : " + user.getPassword() + "]");
	      }

	      //update user
	      User user =userDao.getAllUsers().get(0);
	      user.setName("admin");
	      user.setPassword("admin");
	      userDao.updateUser(user);

	      //get the user
	      userDao.getUser(0);
	      System.out.println("user: [Id : " + user.getId() + ", Name : " + user.getName() + " , "
	         		+ "Password : " + user.getPassword() + "]");	
	      
	      
	      boolean userValidation = userDao.validateUser(userDao.getUser(0));
	      
	      System.out.println("userValidation is "+userValidation);
	      
	      //delete user
	      User user1 = userDao.getAllUsers().get(0);
	      user1.remove(user1.getId());
	      userDao.deleteUser(user1);
	      
	      
	    //After deleting the user get the user
	      userDao.getUser(0);
	      System.out.println("user: [Id : " + user.getId() + ", Name : " + user.getName() + " , "
	         		+ "Password : " + user.getPassword() + "]");	
	      
	   }
}
