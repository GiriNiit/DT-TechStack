<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>

<body>
    
    <jsp:forward page="/CategoryController?action=adminlistCategory"></jsp:forward>
    <jsp:forward page="/SupplierController?action=adminlistSupplier"></jsp:forward>
    <jsp:forward page="/ProductController?action=adminlistProduct"></jsp:forward>
	<jsp:forward page="/AdminRegisterController?action=adminlistRegister"></jsp:forward>
	<jsp:forward page="/UserRegisterController?action=userlistRegister"></jsp:forward>
	<jsp:forward page="/UserEditRegisterController?action=usereditlistRegister"></jsp:forward>
	<jsp:forward page="/AdminAddUserController?action=adminAddlistUser"></jsp:forward>
	
</body>
</html> 