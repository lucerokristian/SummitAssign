<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.RepairInfoDAO" %>
<%@ page import="project.AssetAssignedDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		PrintWriter print = response.getWriter();
		int assetStatusId = Integer.parseInt(request.getParameter("assetId"));
		int repairType = Integer.parseInt(request.getParameter("repairType"));
		String repairCompany = request.getParameter("repairCompany");
		String ticketNumber = request.getParameter("ticketNumber");
		Date ticketDate = new Date();
		String comments = request.getParameter("comments");
	   	RepairInfoDAO repairInfoDAO = new RepairInfoDAO();
	   	AssetAssignedDAO assetAssignedDAO = new AssetAssignedDAO();
   		if(repairInfoDAO.update(repairInfoDAO.getId(assetStatusId), repairType, repairCompany, ticketNumber, ticketDate, comments)){
	   		print.println("<script type=\"text/javascript\">");
			print.println("alert('Successfully entered repair information.');");
			print.println("location='AssetEntry.jsp';");
			print.println("</script>");
	   	}
   		else{	
	   		print.println("<script type=\"text/javascript\">");
			print.println("alert('There was a problem entering the repair information.');");
			print.println("location='AssetEntry.jsp';");
			print.println("</script>");
	   	}
   	%>
	</body>
</html>