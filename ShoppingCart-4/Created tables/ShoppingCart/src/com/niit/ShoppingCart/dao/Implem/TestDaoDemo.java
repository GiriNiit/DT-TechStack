package com.niit.ShoppingCart.dao.Implem;

import java.nio.file.attribute.UserPrincipalLookupService;

import com.niit.ShoppingCart.dao.UserDao;
import com.niit.ShoppingCart.model.User;

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
	      user.setName("Murari");
	      userDao.updateUser(user);

	      //get the user
	      userDao.getUser(0);
	      System.out.println("user: [Id : " + user.getId() + ", Name : " + user.getName() + " , "
	         		+ "Password : " + user.getPassword() + "]");	
	      
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
