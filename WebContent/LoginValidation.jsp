<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.AccountDAO" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Validate Login Information</title>
   </head>
   
   <body>
   	<%
   	PrintWriter print = response.getWriter();
   	String username = request.getParameter("username");
   	String password = request.getParameter("password");
   	AccountDAO ad = new AccountDAO();
   	if(ad.validate(username, password)){
   		session.setAttribute("username", username);
   		session.setAttribute("id", ad.getId(username));
   		session.setAttribute("firstName", ad.getFname((Integer)session.getAttribute("id")));
   		session.setAttribute("lastName", ad.getLname((Integer)session.getAttribute("id")));
   		session.setAttribute("isAdmin", ad.isAdmin((Integer)session.getAttribute("id")));
   		System.out.println(session.getAttribute("id") + " " + session.getAttribute("isAdmin") + session.getAttribute("firstName"));
   	%> 
   		<jsp:forward page="Home.jsp">
   			<jsp:param name="status" value="1"/>
   		</jsp:forward>
   	<% 
   	}  	
   	else{ 
   		print.println("<script type=\"text/javascript\">");
		print.println("alert('Incorrect username and password');");
		print.println("location='Login.html';");
		print.println("</script>");
   	}
   	%>
   </body>
</html>