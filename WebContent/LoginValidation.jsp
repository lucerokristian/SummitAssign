<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.AccountDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Validate Login Information</title>
   </head>
   
   <body>
   	<%
   	String username = request.getParameter("username");
   	String password = request.getParameter("password");
   	AccountDAO ad = new AccountDAO();
   	if(ad.validate(username, password)){
   		session.setAttribute("id", ad.getId(username));
   		session.setAttribute("firstName", ad.getFname((Integer)session.getAttribute("id")));
   		session.setAttribute("lastName", ad.getLname((Integer)session.getAttribute("id")));
   		session.setAttribute("isAdmin", ad.isAdmin((Integer)session.getAttribute("id")));
   		System.out.println(session.getAttribute("id") + " " + session.getAttribute("isAdmin") + session.getAttribute("firstName"));
   	%> 
   		<jsp:forward page="Home.jsp"/>
   	<% 
   	}  	
   	else{ 
   	%>
   		<jsp:forward page="Login.html"/> 
   	<%
   	}
   	%>
   </body>
</html>