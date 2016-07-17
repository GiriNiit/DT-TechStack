<!DOCTYPE html>
<html lang="en">
<head>
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
        <li><a href="productindex.jsp">Products</a></li>
        <!-- <li><a href="Deals.jsp">Deals</a></li>-->
               <li><a href="categoryindex.jsp">Category</a></li>
        <li><a href="supplierindex.jsp">Supplier</a></li>
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


<div class="container">
  <h2><strong>Stores</strong></h2>

  A Pickup store is a value added service for our customers where you can walk in and collect your delivery at your own convenience.
<br><br>
Pickup store facility is currently available at selected pin-codes in the following cities: (launching soon in more cities)
<br><br>

  
Bangalore:<br>
 Address:<br>
  Mirchi Retail Pvt Ltd.<br>
  Plot no. 109,<br>
  Swarg Vihar, Phase 4,<br>
  Karnataka 122015<br><br>
  
Chennai:<br>
 Address:<br>
  Mirchi Retail Pvt Ltd.<br>
  Plot no. 109,<br>
  Swarg Vihar, Phase 4,<br>
  Chennai 122015<br><br>
  
Delhi:<br>
 Address:<br>
  Mirchi Retail Pvt Ltd.<br>
  Plot no. 109,<br>
  Swarg Vihar, Phase 4,<br>
  ChandiniChok 122015<br><br>
  
Hyderabad:<br>
 Address:<br>
  Mirchi Retail Pvt Ltd.<br>
  Plot no. 109,<br>
  Swarg Vihar, Phase 4,<br>
  Secunderabad 122015<br><br>
  
</div>

<footer class="container-fluid text-center">
  <p>Shopping Cart Copyright 2016.<br>All Rights Reserved.</p>
  
</footer>

</body>
</html>


