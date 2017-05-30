<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.SendMail" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>SummitAssign</title>
	</head>
	<body>
	<%
	PrintWriter print = response.getWriter();
	String username = request.getParameter("usernameForgotPassword");
	SendMail sm = new SendMail();
	if(sm.send(username)){
	   print.println("<script type=\"text/javascript\">");
	   print.println("alert('Sent email!');");
	   print.println("location='Login.html';");
	   print.println("</script>");}
	else{
		print.println("<script type=\"text/javascript\">");
		print.println("alert('Error in sending email');");
		print.println("location='ForgotPassword.html';");
		print.println("</script>");
	}
	%>
	</body>
</html>