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

import com.company.dao.AdminAddUserDAO;
import com.company.dao.AdminAddUserDAOImplementation;
import com.company.model.AdminAddUser;


@WebServlet("/AdminAddUserController")
public class AdminAddUserController extends HttpServlet {
	
	private AdminAddUserDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_USER = "/adminAddlistUser.jsp";
	public static final String INSERT_OR_EDIT = "/adminadduser.jsp";
       
    public AdminAddUserController() {
    	dao = new AdminAddUserDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_USER;
			int userId = Integer.parseInt( request.getParameter("userId") );
			dao.deleteUser(userId);
			request.setAttribute("users", dao.getAllUsers() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int userId = Integer.parseInt( request.getParameter("userId") );
			AdminAddUser user = dao.getUserById(userId);
			request.setAttribute("user", user);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_USER;
			request.setAttribute("user", dao.getAllUsers() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminAddUser user = new AdminAddUser();
		user.setUserName( request.getParameter( "userName" ) );
		user.setPassword( request.getParameter( "password" ) );
		user.setRole( request.getParameter( "role" ) );

		
		String userId = request.getParameter("userId");
		
		if( userId == null || userId.isEmpty() ) 
			dao.addUser(user);
		else {
			user.setUserId( Integer.parseInt(userId) );
			dao.updateUser(user);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_USER );
		request.setAttribute("users", dao.getAllUsers());
		view.forward(request, response);
	}
}
