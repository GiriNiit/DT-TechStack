package com.niit.ShoppingCart.dao;

public class UserDAO {

	public boolean isValidCredentials(String UserId,String Password)
	{
		if(UserId.equals("NIIT") && Password.equals("NIIT@123"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
		}
	}

// variable for userId, Password 
// methods - getter and setter 
// map to database table