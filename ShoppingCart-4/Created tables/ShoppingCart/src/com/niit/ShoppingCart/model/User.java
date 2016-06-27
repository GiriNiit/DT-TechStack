package com.niit.ShoppingCart.model;

public class User {
	
	private String name;
	   private int id;
	   private String password;
        

	public User(String name, int id, String password){   //given public before User
	      this.name = name;
	      this.id = id;
	      this.password = password;
	   }

	   public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public int getId() {
	      return id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }

	   
	   //When deleting the user this came.
	   
	public void remove(int id2) {
		// TODO Auto-generated method stub
		
	}
}