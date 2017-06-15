<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
		<body class="col-md">
		<%@include file="Header.jsp"%>
		<div class="page-container">
			<div class="header-title">
			<h1 ><small>Edit User Profile</small></h1>
			</div>
			<div class="col-md-12">

			<form class="form-horizontal" role="form" method="post" action="EditController">
          
          
          <div class="form-group">
            <label class="col-md-3 control-label">Username:</label>
            <div class="col-md-8">
              <input class="form-control" type="text" placeholder="Username" name="username" value="<c:out value="${user.username}" />">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" placeholder="Email"value="" name="email">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Role:</label>
            <div class="col-lg-8">
              <div class="ui-select">
                <select id="Role" class="form-control" name="role">
                 <option value="Admin">Admin</option>
                 <option value="systemadmin">System Admin</option>
                 <option value="authorized">Authorized user</option>
                </select>
              </div>
            </div>
          </div>
        
          
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <!-- <input type="button" class="btn btn-primary" name="action"value="Save Changes"> -->
              <button type="submit" class="btn btn-primary" >Edit</button>
              <span></span>
              <input type="reset" class="btn btn-default" onClick="location.href='UserMaintenance.jsp'" value="Cancel">
            </div>
          </div>
        </form>
				
			</div>
			
		</div>

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
		    
		   	ChartsFlotcharts.initBarCharts();
		});
			</script>
			<%@include file="Footer.jsp"%>
		</body>
		</html>