package com.company.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.CategoryDAO;
import com.company.dao.CategoryDAOImplementation;
import com.company.model.Category;


@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	
	private CategoryDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_CATEGORY = "/adminlistCategory.jsp";
	public static final String INSERT_OR_EDIT = "/admincategory.jsp";
       
    public CategoryController() {
    	dao = new CategoryDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		String user = request.getParameter("userId");
		
		if(user.equals("admin")){
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_CATEGORY;
			int categoryId = Integer.parseInt( request.getParameter("categoryId") );
			dao.deleteCategory(categoryId);
			request.setAttribute("categorys", dao.getAllCategorys() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int categoryId = Integer.parseInt( request.getParameter("categoryId") );
			Category category = dao.getCategoryById(categoryId);
			request.setAttribute("category", category);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_CATEGORY;
			request.setAttribute("categorys", dao.getAllCategorys() );
		}
		} else
		{
			forward = lIST_CATEGORY;
			request.setAttribute("categorys", dao.getAllCategorys() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = new Category();
		category.setCateName( request.getParameter( "cateName" ) );
		category.setCateDescription( request.getParameter( "cateDescription" ) );
		String categoryId = request.getParameter("categoryId");
		
		if( categoryId == null || categoryId.isEmpty() ) 
			dao.addCategory(category);
		else {
			category.setCategoryId( Integer.parseInt(categoryId) );
			dao.updateCategory(category);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_CATEGORY );
		request.setAttribute("categorys", dao.getAllCategorys());
		view.forward(request, response);
	}
}
