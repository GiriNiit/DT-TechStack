package com.niit.ShoppingCart.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import org.h2.Driver;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.ShoppingCart.dao.UserDAO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    	
    	
    }

	/**
	 * @param UserID 
	 * @param Password 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: LOCALHOST: ").append(request.getContextPath());
		
		String userId= (String) request.getParameter("UserID");
    	String password=(String) request.getParameter("Password");
    	
    	System.out.println("userId is "+userId+" \t password is "+password);
    	
    	
//DB connectivity for h2 database and loginservlet
  
    	        try {
    	        	System.out.println("INSIDE TRY");
					Class.forName("org.h2.Driver");
					String url = "jdbc:h2:tcp://localhost/~/test";
					String dbUsername = "sa";
					String dbPassword = "";
					Connection conn = DriverManager.getConnection(url,dbUsername,dbPassword);
					System.out.println("H2 Database connected successfully");
					
					RequestDispatcher dispatcher = null;
					
					UserDAO userDAO = new UserDAO();
			    	if(userDAO.isValidCredentials(userId,password))
			       	{
			    		dispatcher=request.getRequestDispatcher("home.html");
			    		dispatcher.forward(request, response);
			    	}
			    	else
			    	{
			    	        dispatcher=request.getRequestDispatcher("loginfailed.html");
		    	    		dispatcher.forward(request, response);
		    	    	}
    	        }
    	        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
    	        }
				    catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
    	       
    	       
	}


    	/*This is the code when we dont connect to DB
    	 * 
    	 * UserDAO userDAO = new UserDAO();
    	
    	if(userDAO.isValidCredentials(userId,password))
    		
    	{
    		RequestDispatcher dispatcher=request.getRequestDispatcher("home.html");
    		dispatcher.forward(request, response);
    	}
    	else
    	{
    		PrintWriter out=response.getWriter();
    		out.print("Invalid Credentials");
    		RequestDispatcher dispatcher=request.getRequestDispatcher("loginfailed.html");
    		dispatcher.forward(request, response);
    		
    	}
    	*/
	
    		
	

    	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	}
