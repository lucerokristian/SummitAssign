<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.AssetDAO" %>
<%@ page import="project.AssetAssignedDAO" %>
<%@ page import="project.RepairInfoDAO" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Asset Entry Validation</title>
	</head>
	<body>
		<%
		PrintWriter print = response.getWriter();
	   	String branch = request.getParameter("branch");
	   	String assetTag = request.getParameter("assetTag");
	   	int status = Integer.parseInt(request.getParameter("status"));
	   	String assetType = request.getParameter("assetType");
	   	String model = request.getParameter("model");
	   	String serialNumber = request.getParameter("serialNumber");
	   	String purchaseOrder = request.getParameter("purchaseOrder");
	   	String unitCost = request.getParameter("unitCost");
	   	String location = request.getParameter("location");
	   	String building = request.getParameter("building");
	   	String roomNumber = request.getParameter("roomNumber");
	   	String softwareOs = request.getParameter("softwareOs");
	   	String description = request.getParameter("description");
	   	Date scanDate = new Date();
   		boolean bool = false;
	   	AssetDAO assetDAO = new AssetDAO();
	   	AssetAssignedDAO assetAssignedDAO = new AssetAssignedDAO();
	   	RepairInfoDAO repairInfoDAO = new RepairInfoDAO();
	   	if(branch != null && assetTag != null && status != 0 && assetType != null){
	   		if(softwareOs != null){
		   		if(softwareOs.equals("Yes"))
		   			bool = true;
	   		}
	   		int i = assetDAO.add(branch, assetTag, status, assetType, model, serialNumber, purchaseOrder, unitCost, location, building, roomNumber, bool, description, scanDate);
	   		//if status is repair create row in repair_info table
	   		if(i > 0){ 
	   			if(status == 3){
		   			int x = repairInfoDAO.addRow(i);
		   		}
	   			assetAssignedDAO.add(0, i); //insert row in asset_assigned table
			   	print.println("<script type=\"text/javascript\">");
				print.println("alert('Successfully added asset.');");
				print.println("location='AssetEntry.jsp';");
				print.println("</script>");
	   		}else{	
		   		print.println("<script type=\"text/javascript\">");
				print.println("alert('There was a problem adding the asset.');");
				print.println("location='AssetEntry.jsp';");
				print.println("</script>");
	   		}
	   	}
	   	%>
	</body>
</html>