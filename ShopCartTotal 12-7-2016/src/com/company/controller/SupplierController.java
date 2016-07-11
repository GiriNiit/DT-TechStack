package com.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.company.dao.SupplierDAO;
import com.company.dao.SupplierDAOImplementation;
import com.company.model.Supplier;


@WebServlet("/SupplierController")
public class SupplierController extends HttpServlet {
	
	private SupplierDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_SUPPLIER = "/adminlistSupplier.jsp";
	public static final String INSERT_OR_EDIT = "/adminsupplier.jsp";
       
    public SupplierController() {
    	dao = new SupplierDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_SUPPLIER;
			int supplierId = Integer.parseInt( request.getParameter("supplierId") );
			dao.deleteSupplier(supplierId);
			request.setAttribute("suppliers", dao.getAllSuppliers() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int supplierId = Integer.parseInt( request.getParameter("supplierId") );
			Supplier supplier = dao.getSupplierById(supplierId);
			request.setAttribute("supplier", supplier);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_SUPPLIER;
			request.setAttribute("suppliers", dao.getAllSuppliers() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Supplier supplier = new Supplier();
		
		//supplier.setSupplierId( request.getInt( "supplierId" ) );
		
		supplier.setSupplierName( request.getParameter( "supplierName" ) );
		supplier.setSupplierAddress ( request.getParameter( "supplierAddress" ) );
		supplier.setSupplierContact( Integer.parseInt( request.getParameter( "supplierContact" ) ) );
		//supplier.setProductId( Integer.parseInt( request.getParameter( "ProductId" ) ) );
		//supplier.setCategoryId( Integer.parseInt( request.getParameter( "CategoryId" ) ) );
		supplier.setCategoryName( request.getParameter( "categoryName" ) );
		String supplierId = request.getParameter("supplierId");
		String productId = request.getParameter("productId");
		String categoryId = request.getParameter("categoryId");
		
				
		if( supplierId == null || supplierId.isEmpty() ) 
			dao.addSupplier(supplier);
		else {
			supplier.setSupplierId( Integer.parseInt(supplierId) );
			dao.updateSupplier(supplier);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_SUPPLIER );
		request.setAttribute("suppliers", dao.getAllSuppliers());
		view.forward(request, response);
	}
}
