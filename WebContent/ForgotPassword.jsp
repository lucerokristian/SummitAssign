<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.AccountDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>SummitAssign</title>
	</head>
	<body>
	<%
	String username = request.getParameter("usernameForgotPassword");
	AccountDAO ad = new AccountDAO();
	if(ad.sendMail(username)){
	%>
		<jsp:forward page="Login.html"/>
	<%}
	else{
	%>
		<jsp:forward page="ForgotPassword.html"/>	
	<%
	}
	%>
	</body>
</html>