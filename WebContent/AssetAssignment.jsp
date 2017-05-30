<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.AssetAssignedDAO" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		PrintWriter print = response.getWriter();
	   	int userId = Integer.parseInt(request.getParameter("userId"));
	   	int assetId = Integer.parseInt(request.getParameter("assetId"));
	   	AssetAssignedDAO assetAssignedDAO = new AssetAssignedDAO();
   		if(assetAssignedDAO.update(assetAssignedDAO.getId(assetId), userId)){
	   		print.println("<script type=\"text/javascript\">");
			print.println("alert('Successfully assigned asset.');");
			print.println("location='AssetEntry.jsp';");
			print.println("</script>");
	   	}
   		else{	
	   		print.println("<script type=\"text/javascript\">");
			print.println("alert('There was a problem assigning the asset.');");
			print.println("location='AssetEntry.jsp';");
			print.println("</script>");
	   	}
   	%>
	</body>
</html>