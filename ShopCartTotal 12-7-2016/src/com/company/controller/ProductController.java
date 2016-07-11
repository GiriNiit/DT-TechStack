package com.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.ProductDAO;
import com.company.dao.ProductDAOImplementation;
import com.company.model.Product;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	
	private ProductDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_PRODUCT = "/adminlistProduct.jsp";
	public static final String INSERT_OR_EDIT = "/adminproduct.jsp";
       
    public ProductController() {
    	dao = new ProductDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_PRODUCT;
			int productId = Integer.parseInt( request.getParameter("productId") );
			dao.deleteProduct(productId);
			request.setAttribute("products", dao.getAllProducts() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int productId = Integer.parseInt( request.getParameter("productId") );
			Product product = dao.getProductById(productId);
			request.setAttribute("product", product);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_PRODUCT;
			request.setAttribute("products", dao.getAllProducts() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setProductName( request.getParameter( "productName" ) );
		product.setProductDescription( request.getParameter( "productDescription" ) );
		
		String productId = request.getParameter("productId");
		String categoryId = request.getParameter("categoryId");
				
		if( productId == null || productId.isEmpty() ) 
			dao.addProduct(product);
		else {
			product.setProductId( Integer.parseInt(productId) );
			dao.updateProduct(product);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_PRODUCT );
		request.setAttribute("products", dao.getAllProducts());
		view.forward(request, response);
	}
}
