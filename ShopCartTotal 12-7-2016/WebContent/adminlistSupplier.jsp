<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Online Shopping</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
      /* Remove the navbar's default rounded borders and increase the bottom margin */
    .navbar {
	background-color: indigo;
      margin-bottom: 50px;
      border-radius: 10px;
    }
    
    /* Remove the well's default bottom margin */
     .well {
	 background-color: lightblue;
      margin-bottom: 0%;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: lightblue;
      padding: 20px;
    }
	
	 .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
  
  text-align:base
  padding:100px,100px;
     width:40%;
      margin: 0 auto;
  }
  </style>
</head>
<body>

<div class="well">
  <div class="container text-center">
  
     <h1><strong><b><i>InfoGrab</i></b></strong></h1>
    <h5>WELCOME TO THE WORLD OF GADGETS</h5>  </div>
</div>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="adminonline.jsp">Home</a></li>
        <li><a href="adminproduct.jsp">Products</a></li>
        <!-- <li><a href="Deals.jsp">Deals</a></li>-->
               <li><a href="admincategory.jsp">Category</a></li>
        <li><a href="adminsupplier.jsp">Supplier</a></li>
          <li><a href="adminstores.jsp">Stores</a></li>
        <li><a href="admincontact.jsp">Contact</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <!--  <li><a href="I/myaccount.jsp"><span class="glyphicon glyphicon-user">
	  </span> Your Account</a></li>
        <li><a href="I/cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>-->
    
    <li><a><span class="glyphicon welcome">
	  </span><font color="white">Welcome!</font></a></li>
	  
	<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"style="padding-right: 4px";>
	  </span>SignIn</a></li>
	  
	 <li><a href="adminregister.jsp"><span class="glyphicon glyphicon-user" style="padding-right: 4px";>
	  </span>Register</a></li>
	  	  
	 </ul>
    </div>
  </div>
</nav>


<body>
	
		<div class="container">
        <table class="table table-bordered">

        
            <caption><h2>Supplier Details</h2></caption>
            <tr>
			<thead>
			<tr>

			
				<th>Supplier ID</th>
				<th>Supplier Name</th>
				<th>Supplier Address</th>
				<th>Supplier Contact</th>
				<th>Product Id</th>
				<th>Category Id</th>
				<th>Category Name</th>
				
				
				
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${suppliers}" var="supplier">
				<tr>
					<td><c:out value="${supplier.supplierId}" /></td>
					<td><c:out value="${supplier.supplierName}" /></td>
					<td><c:out value="${supplier.supplierAddress}" /></td>
					<td><c:out value="${supplier.supplierContact}" /></td>
					<td><c:out value="${supplier.productId}" /></td>
					<td><c:out value="${supplier.categoryId}" /></td>
					<td><c:out value="${supplier.categoryName}" /></td>
					
					
					<td><a
						href="SupplierController.do?action=edit&supplierId=<c:out value="${supplier.supplierId }"/>">
						<input type="submit" class="btn btn-info" value="Update" /></a></td>
					<td><a
						href="SupplierController.do?action=delete&supplierId=<c:out value="${supplier.supplierId }"/>">
						<input type="submit" class="btn btn-info" value="Delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="SupplierController.do?action=insert">
		<input type="submit" class="btn btn-info" value="Add Supplier" /></a>
	</p></div>
</body>


<footer class="container-fluid text-center">
  <p>Shopping Cart Copyright 2016.<br>All Rights Reserved.</p>
  
</footer>

</body>
</html>


