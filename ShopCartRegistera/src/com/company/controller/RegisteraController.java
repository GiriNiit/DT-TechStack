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

import com.company.dao.RegisterDAO;
import com.company.dao.RegisterDAOImplementation;
import com.company.dao.RegisteraDAO;
import com.company.dao.RegisteraDAOImplementation;
import com.company.model.Register;
import com.company.model.Registera;


@WebServlet("/RegisteraController")
public class RegisteraController extends HttpServlet {
	
	private RegisteraDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_REGISTERA = "/listRegistera.jsp";
	public static final String INSERT_OR_EDIT = "/registera.jsp";
       
    public RegisteraController() {
    	dao = new RegisteraDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_REGISTERA;
			int registerId = Integer.parseInt( request.getParameter("registerId") );
			dao.deleteRegistera(registerId);
			request.setAttribute("registers", dao.getAllRegisteras() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int registerId = Integer.parseInt( request.getParameter("registerId") );
			Registera registera = dao.getRegisteraById(registerId);
			request.setAttribute("register", registera);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_REGISTERA;
			request.setAttribute("registeras", dao.getAllRegisteras() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Registera registera = new Registera();
		registera.setFirstName( request.getParameter( "firstName" ) );
		registera.setLastName( request.getParameter( "lastName" ) );
		registera.setEmail( request.getParameter( "email" ) );
		registera.setDob( request.getParameter( "dob" ) );
		registera.setGender( request.getParameter( "gender" ) );
		String registerId = request.getParameter("registerId");
		
		if( registerId == null || registerId.isEmpty() ) 
			dao.addRegistera(registera);
		else {
			registera.setRegisterId( Integer.parseInt(registerId) );
			dao.updateRegistera(registera);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_REGISTERA );
		request.setAttribute("registers", dao.getAllRegisteras());
		view.forward(request, response);
	}
}
