<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.AssetAssignedDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<%
	   	int userId = Integer.parseInt(request.getParameter("userId"));
	   	int assetId = Integer.parseInt(request.getParameter("assetId"));
	   	AssetAssignedDAO assetAssignedDAO = new AssetAssignedDAO();
   		if(assetAssignedDAO.update(assetAssignedDAO.getId(assetId), userId)){ 
	   	%>
   			<script>alert("Successfully assigned asset.");</script>
   			<jsp:forward page="AssetEntry.jsp"/>
	   	<%	}else{	%>
	   		<script>alert("There was a problem assigning the asset.");</script>
	   		<jsp:include page="AssetEntry.jsp"/>
	   	<%}
	   	%>
	</body>
</html>