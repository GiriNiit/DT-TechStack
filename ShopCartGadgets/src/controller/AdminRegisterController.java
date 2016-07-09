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

import com.company.dao.AdminRegisterDAO;
import com.company.dao.AdminRegisterDAOImplementation;
import com.company.model.AdminRegister;


@WebServlet("/AdminRegisterController")
public class AdminRegisterController extends HttpServlet {
	
	private AdminRegisterDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_REGISTER = "/adminlistRegister.jsp";
	public static final String INSERT_OR_EDIT = "/adminregister.jsp";
       
    public AdminRegisterController() {
    	dao = new AdminRegisterDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_REGISTER;
			int registerId = Integer.parseInt( request.getParameter("registerId") );
			dao.deleteRegister(registerId);
			request.setAttribute("registers", dao.getAllRegisters() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int registerId = Integer.parseInt( request.getParameter("registerId") );
			AdminRegister register = dao.getRegisterById(registerId);
			request.setAttribute("register", register);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_REGISTER;
			request.setAttribute("registers", dao.getAllRegisters() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminRegister register = new AdminRegister();
		register.setFirstName( request.getParameter( "firstName" ) );
		register.setLastName( request.getParameter( "lastName" ) );
		register.setEmail( request.getParameter( "email" ) );
		register.setDob( request.getParameter( "dob" ) );
		register.setGender( request.getParameter( "gender" ) );
		register.setAuthentication( request.getParameter( "authentication" ) );

		String registerId = request.getParameter("registerId");
		
		if( registerId == null || registerId.isEmpty() ) 
			dao.addRegister(register);
		else {
			register.setRegisterId( Integer.parseInt(registerId) );
			dao.updateRegister(register);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_REGISTER );
		request.setAttribute("registers", dao.getAllRegisters());
		view.forward(request, response);
	}
}
