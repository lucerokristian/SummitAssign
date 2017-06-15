<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c"  %> 
		<!DOCTYPE html>
		<html lang="en">
		<!--<![endif]-->
		<!-- BEGIN HEAD -->
		<head>
		<meta charset="utf-8"/>
		<title>Dashboard | Report</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<meta content="" name="description"/>
		<meta content="" name="author"/>
		<!-- BEGIN GLOBAL MANDATORY STYLES -->
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
		<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
		<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
		<!-- END GLOBAL MANDATORY STYLES -->
		<!-- BEGIN THEME STYLES -->
		<link href="assets/global/css/components-md.css" id="style_components" rel="stylesheet" type="text/css">
		<link href="assets/global/css/plugins-md.css" rel="stylesheet" type="text/css">
		<link href="assets/admin/layout3/css/layout.css" rel="stylesheet" type="text/css">
		<link href="assets/admin/layout3/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
		<link href="assets/admin/layout3/css/custom.css" rel="stylesheet" type="text/css">
		<!-- END THEME STYLES -->
		<link rel="shortcut icon" href="favicon.ico"/>
		</head>
		<body class="page-md">
		<%@include file="Header.jsp"%>
			<div class="page-container">
				<div class="pager-header">
					<div class="page-title">
						
						<h1><small>Master User Maintenance</small></h1>
					</div>
					<!-- END OF PAGE TITLE -->
					
					<div class="form-group">
						
						<!-- <div class="col-md-3">
						<select class="form-control" name="select">
								<option>ALL</option>
								<option value="active">Active</option>
								<option value="inactive">Inactive</option>
								
						</select>
						</div> -->
						<!-- <div class="col-md-3">
							<button type="button" class="btn btn-primary blue">Search</button>
						</div> -->
						<div class="col-md-3">
							<button type="button" class="btn btn-primary blue pull-right" onClick="location.href='Home.jsp'">Add a New Asset</button>
						</div>
						<!-- <div class="col-md-3">
							<button type="button" class="btn btn-primary blue pull-right" onClick="location.href='UserMaintenanceRepair.jsp'">Repair Asset</button>
						</div> -->
					</div>
					<div></div>
					<!-- BEGIN TABLE -->
					<div class="col-md-12">
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption">
								<i class="fa fa-search"></i>
									<span class="cation-subject font-green bold uppercase">Search Result</span>
								</div>

							</div>
							<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
								<thead>
								<tr>
									
									<th>
										 Branch Name
									</th>
									<th>
										Type
									</th>
									<th>
										Model
									</th>
									
									
									<th>
										 Status
									</th>
									<th>
										 Edit
									</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${user}" var="user">
								<tr>
                                <td><c:out value="${user.branch}" /></td>
                                <td><c:out value="${user.assetType}" /></td>
								
                    			<td><c:out value="${user.model}" /></td>
                    			<td><c:out value="${user.status}" /></td>
                    			<td><a href="AssetEditController?action=updateasset&assettype=<c:out value="${user.assetType}"/>"><i class="fa fa-edit"></i></a></td>
                    			<%-- <a href="UserController?action=delete&userId=<c:out value="${user.uname}"/> --%>
                    			</tr>
                    			</c:forEach>
								</tbody>
								</table>
							</div>
						</div>
						</div>
					</div>
					<!-- END OF TABLE -->
				</div>
				<!-- END OF PAGE HEADER -->
			</div>
			<!-- END OF CONTAINER -->
			<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
			<script src="assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
			<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
			<script src="assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
			<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
			<script src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
			<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
			<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
			<script src="assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
			<script src="assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
			<!-- END CORE PLUGINS -->
			<!-- BEGIN PAGE LEVEL SCRIPTS -->
			<script src="assets/global/scripts/metronic.js" type="text/javascript"></script>
			<script src="assets/admin/layout3/scripts/layout.js" type="text/javascript"></script>
			<script src="assets/admin/layout3/scripts/demo.js" type="text/javascript"></script>
			<script src="assets/global/plugins/flot/jquery.flot.min.js"></script>
			<script src="assets/global/plugins/flot/jquery.flot.resize.min.js"></script>
			<script src="assets/global/plugins/flot/jquery.flot.pie.min.js"></script>
			<script src="assets/global/plugins/flot/jquery.flot.stack.min.js"></script>
			<script src="assets/global/plugins/flot/jquery.flot.crosshair.min.js"></script>
			<script src="assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
			<script src="assets/admin/pages/scripts/charts-flotcharts.js"></script>
		<!-- END PAGE LEVEL SCRIPTS -->
			<script>
		jQuery(document).ready(function() { 
			// initiate layout and plugins
		    Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
		});
			</script>
			<%@include file="Footer.jsp"%>
	</body>
</html>	