package com.niit.ShoppingCart.NoDB.Dao;

import java.util.List;

import com.niit.ShoppingCart.NoDB.Model.User;

public interface UserDao {
	   public List<User> getAllUsers();
	   public User getUser(int id);
	   public void updateUser(User user);
	   public void deleteUser(User user);
	   public boolean validateUser(User user);
}
