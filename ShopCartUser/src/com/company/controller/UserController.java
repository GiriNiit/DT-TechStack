package com.company.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.UserDAO;
import com.company.dao.UserDAOImplementation;
import com.company.model.User;
import com.company.dao.UserDAO;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	
	private UserDAO dao;
	private static final long serialVersionUID = 1L;
	
       
    public UserController() {
    	dao = new UserDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: LOCALHOST  ").append(request.getContextPath());
				
		String userId = (String) request.getParameter("UserID");
		String password = (String) request.getParameter("Password");
		System.out.println("userId is " + userId + " password is " + password);
		
		try {
			System.out.println("INSIDE TRY");
			
			System.out.println("H2 DATABASE CONNECTED ***************");

			
			boolean validUser = validateUser(userId,password);

			System.out.println("validUser is " + validUser);
			
			RequestDispatcher dispatcher = null;

			if (validUser) {
				System.out.println("inside admin login");
				dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			} else if (validUser && userId.equals("user")) {
				System.out.println("inside user login");
				dispatcher = request.getRequestDispatcher("home1.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("inside other users");
				dispatcher = request.getRequestDispatcher("loginfailed.jsp");
				dispatcher.forward(request, response);
			}

		} catch(Exception e){
			
		}
		
	}
		public boolean validateUser(String userId,String password) {
			
			UserDAO userDao = new UserDAOImplementation();
			
			String adminDbUser = userDao.getUserById(2).getUserName();
			String adminDbPassword = userDao.getUserById(2).getPassword();
			
			System.out.println("adminDbUser "+adminDbUser +"adminDbPassword "+ adminDbPassword );
			
			if (userId.equals(adminDbUser) && password.equals(adminDbPassword)) {
				return true;
			}

			
			return false;

		}

	

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserName( request.getParameter( "UserName" ) );
		user.setPassword( request.getParameter( "password" ) );
		String userId = request.getParameter("userId");
		
		if( userId == null || userId.isEmpty() ) 
			dao.addUser(user);
		else {
			user.setUserId( Integer.parseInt(userId) );
			dao.updateUser(user);
		}
		doGet(request, response);
			}
}
