package com.company.model;


import java.util.Date;

public class UserRegister{

	private int registerId;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String gender;
	private String requestaccess;

	public int getRegisterId() {
		return registerId;
	}


	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}


	

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	

	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRequestaccess() {
		return requestaccess;
	}


	public void setRequestaccess(String requestaccess) {
		this.requestaccess = requestaccess;
	}

		
	
	@Override
	public String toString() {
		return "Register [registerId=" + registerId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", dob="
				+ dob + ",  gender=" + gender + ",  requestaccess=" + requestaccess + "]";
	}


			
}
