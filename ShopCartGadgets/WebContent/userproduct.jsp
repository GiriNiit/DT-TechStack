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
    <h5>WELCOME TO THE WORLD OF GADGETS</h5>
  </div>
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
        <li><a href="useronline.jsp">Home</a></li>
        <li><a href="userproduct.jsp">Products</a></li>
        <!-- <li><a href="Deals.jsp">Deals</a></li>-->
               <li><a href="usercategory.jsp">Category</a></li>
       <!--   <li><a href="supplier.jsp">Supplier</a></li>-->
          <li><a href="userstores.jsp">Stores</a></li>
        <li><a href="usercontact.jsp">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <!--  <li><a href="I/myaccount.jsp"><span class="glyphicon glyphicon-user">
	  </span> Your Account</a></li>
        <li><a href="I/cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>-->
    
    <li><a><span class="glyphicon welcome">
	  </span><font color="white">Welcome!</font></a></li>
	  
	<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"style="padding-right: 4px";>
	  </span>SignIn</a></li>
	  
	 <li><a href="userregister.jsp"><span class="glyphicon glyphicon-user" style="padding-right: 4px";>
	  </span>Register</a></li>
	  
	 </ul>
    </div>
  </div>
</nav>


<body>

<div class="container">
  <h2><strong>Products<strong></h2><br><br>



<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
  <a href="useronline.jsp">
  
  <div class="panel-body"><img src="Images/pic22.jpg" class="img-responsive" style="width:140%" alt="Image"><br>
  </div>
    </div></div>
   <div class="col-sm-4">
      <div class="panel panel-danger">
   <div class="panel-body"><img src="Images/pic24.jpg" class="img-responsive" style="width:140%" alt="Image"><br>
  </div>
    </div>
    </div>
    
   <div class="col-sm-4">
      <div class="panel panel-danger">
   <div class="panel-body"><img src="Images/pic25.jpg" class="img-responsive" style="width:80%" alt="Image"><br>
	</div>
    </div></div>
	 <div class="col-sm-4">
      <div class="panel panel-danger">
	 <div class="panel-body"><img src="Images/pic26.jpg" class="img-responsive" style="width:180%" alt="Image"><br>
	  </div>
    </div></div>
	   <div class="col-sm-4">
      <div class="panel panel-danger">
	  <div class="panel-body"><img src="Images/pic27.jpg" class="img-responsive" style="width:60%" alt="Image"><br>
	  </div>
    </div></div>
	   <div class="col-sm-4">
      <div class="panel panel-danger">
	   <div class="panel-body"><img src="Images/pic28.jpg" class="img-responsive" style="width:100%" alt="Image"><br>
	    </div>
    </div></div>
	     <div class="col-sm-4">
      <div class="panel panel-danger">
	    <div class="panel-body"><img src="Images/pic29.jpg" class="img-responsive" style="width:140%" alt="Image"><br>
		 </div>
    </div></div>
		  <div class="col-sm-4">
      <div class="panel panel-danger">
		 <div class="panel-body"><img src="Images/pic30.jpg" class="img-responsive" style="width:140%" alt="Image"><br>
		 </div>
    </div></div>
		 
		  <div class="col-sm-4">
      <div class="panel panel-danger"> 
      	   <div class="panel-body"><img src="Images/pic31.jpg" class="img-responsive" style="width:140%" alt="Image"><br>
			 </div>
    </div></div>
		   </div></a>
		   
		 </div></div> 
		  
<footer class="container-fluid text-center">
  <p>Shopping Cart Copyright 2016.<br>All Rights Reserved.</p>
  
</footer>

</body>
</html>

