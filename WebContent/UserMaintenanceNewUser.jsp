<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<div class="header-title">
				<h1 ><small>New User</small></h1>
				</div>
				<div class="col-md-12">
				<div class="portlet light">
						
						<div class="portlet-body form">
							<form role="form" class="form-horizontal" method="post" action="AssetController">
								<div class="form-body">
									<div class="form-group ">
										<label class="col-md-2 control-label" for="form_control_1">First Name</label>
										<div class="col-md-10">
											<input type="text" class="form-control" id="form_control_1" placeholder="First Name" name="firstname">
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-2 control-label" for="form_control_1">Last Name</label>
										<div class="col-md-10">
											<input type="text" class="form-control" id="form_control_1" placeholder="Last Name" name="lastname">
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<div class="form-group  ">
										<label class="col-md-2 control-label" for="form_control_1">UserName</label>
										<div class="col-md-10">
											<input type="text" class="form-control" id="form_control_1" placeholder="UserName" name="username">
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<div class="form-group  ">
										<label class="col-md-2 control-label" for="form_control_1">Email</label>
										<div class="col-md-10">
											<input type="text" class="form-control" id="form_control_1" placeholder="Email" name="email">
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-2 control-label" for="form_control_1">Password</label>
										<div class="col-md-10">
											<input type="Password" class="form-control" id="form_control_1" placeholder="Password" name="password">
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<div class="form-group  ">
										<label class="col-md-2 control-label" for="form_control_1">Confirm Password</label>
										<div class="col-md-10">
											<input type="Password" class="form-control" id="form_control_1" placeholder="Password">
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-2 control-label" for="form_control_1">Role</label>
										<div class="col-md-10">
											<select class="form-control" id="form_control_1" name="role">
												<option value=""></option>
												<option value="system Admin">System Admin</option>
												<option value="Authorized User">Authorized User</option>
												
											</select>
										</div>
									</div>	
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-2 col-md-10">
											<button type="button" class="btn red" onClick="location.href='UserMaintenance.jsp'">Cancel</button>
											<button type="submit" class="btn blue" onClick="location.href='UserMaintenanceS.jsp'" name="action" value="saveuser"  >Save</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						</div>
			</div>
			<%@include file="Footer.jsp"%>
		</body>
		</html>