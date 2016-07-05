package com.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.company.dao.User1DAO;
import com.company.dao.User1DAOImplementation;
import com.company.model.User1;


@WebServlet("/User1Controller")
public class User1Controller extends HttpServlet {
	
	private User1DAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_USER1 = "/listUser1.jsp";
	public static final String INSERT_OR_EDIT = "/user1.jsp";
       
    public User1Controller() {
    	dao = new User1DAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_USER1;
			int userId = Integer.parseInt( request.getParameter("userId") );
			dao.deleteUser1(userId);
			request.setAttribute("user1s", dao.getAllUser1s() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int userId = Integer.parseInt( request.getParameter("userId") );
			User1 user1 = dao.getUser1ById(userId);
			request.setAttribute("user1", user1);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_USER1;
			request.setAttribute("user1s", dao.getAllUser1s() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User1 user1 = new User1();
		user1.setUserName( request.getParameter( "userName" ) );
		user1.setPassword( request.getParameter( "password" ) );
		
		String userId = request.getParameter("userId");
		
		if( userId == null || userId.isEmpty() ) 
			dao.addUser1(user1);
		else {
			user1.setUserId( Integer.parseInt(userId) );
			dao.updateUser1(user1);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_USER1 );
		request.setAttribute("user1s", dao.getAllUser1s());
		view.forward(request, response);
	}
}
