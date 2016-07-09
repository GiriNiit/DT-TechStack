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

  <h3><strong>Edit Your Details:</strong><br></h3>
    
<br>

<form action="AdminRegisterController.do" method="post">
		<fieldset>
			<div>
			
			      
				<label for="registerId">Register ID:</label> <input type="text"
				class="form-control"
					name="registerId" value="<c:out value="${register.registerId}" />"
					readonly="readonly" placeholder="Auto Generates" />
			</div>
			<br>
			
			<div>
				<label for="firstName">First Name:</label> <input type="text"
				class="form-control"
					name="firstName" value="<c:out value="${register.firstName}" />"
					placeholder="First Name" />
			</div>
			<br>
			
			<div>
				<label for="lastName">Last Name:</label> <input type="text"
				class="form-control"
					name="lastName" value="<c:out value="${register.lastName}" />"
					placeholder="Last Name" />
			</div>
			<br>
			
			<div>
				<label for="email">Email</label> <input type="text" name="email"
				class="form-control"
					value="<c:out value="${register.email}" />" placeholder="Email Id" />
			</div>
	<br>
	<div>
	<label for="dob">Date of Birth:</label> 

<input type="date" name="dob"
		value="<c:out value="${register.dob}" />"  />
</div>
<br>

<div>
<label for="gender">Gender:</label> 

<input type="radio" name="gender" value="male" > Male
  <input type="radio" name="gender" value="female"> Female
  <c:out value="${register.gender}" />
</div><br>


	    
	    <div>
<label for="authentication">Authentication:</label> 

<input type="radio" name="authentication" value="admin" > Admin
  <input type="radio" name="authentication" value="user"> User
  <c:out value="${register.authentication}" />
</div><br>

	<a href="Congrats.jsp">
    <input type="submit" class="btn btn-info" value="Submit">
    </a>
	    <a href="online.jsp">
	    <input type="reset" class="btn btn-info" value="Reset">
	    </a>
    
     </fieldset>
     
       
      </form>
      
   
  <br><br>
  

<footer class="container-fluid text-center">
    <p>Shopping Cart Copyright 2016.<br>All Rights Reserved.</p>
  
</footer>

</body>
</html>



</body>
</html>
