<%@ page import="project.AssetDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="project.Asset" %>
<%@ page import="project.AccountDAO" %>
<%@ page import="project.Account" %>
<!DOCTYPE html>
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>Dashboard | Asset Entry</title>
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
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-menu-fixed" class to set the mega menu fixed  -->
<!-- DOC: Apply "page-header-top-fixed" class to set the top menu fixed  -->
<body class="page-md">
<%@include file="Header.jsp"%>

<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>Asset Entry</h1>
			</div>
			<!-- END PAGE TITLE -->
		</div>
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="container">
		<!-- BEGIN PAGE CONTENT INNER -->
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-5">
			 	<!-- asset entry panel -->
			 	<!-- BEGIN SAMPLE FORM PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption">
								<span class="caption-subject font-blue-sharp bold uppercase">Asset Details</span>
							</div>
						</div>
						<div class="portlet-body form">
							<form class="form-horizontal" role="form" action="AssetEntryValidation.jsp" method="POST">
								<div class="form-body">
									<div class="form-group">
										<label class="col-md-3 control-label">Branch<span style="color:red"> *</span></label>
										<div class="col-md-9">
											<select class="form-control" name="branch" required>
												<option disabled selected value> -- Select an option -- </option>
												<option value="SummitWorks Technologies Inc.">SummitWorks Technologies Inc</option>
												<option value="TekBasic LLC">TekBasic LLC</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Asset Tag<span style="color:red"> *</span></label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" name="assetTag" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Status<span style="color:red"> *</span></label>
										<div class="col-md-9">
											<select class="form-control" name="status" required>
												<option disabled selected value> -- Select an option -- </option>
												<option value="1">Active</option>
												<option value="2">Inactive</option>
												<option value="3">Repair</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Type<span style="color:red"> *</span></label>
										<div class="col-md-9">
											<select class="form-control" name="assetType" required>
												<option disabled selected value> -- Select an option -- </option>
												<option>Headphones</option>
												<option>Amplifier</option>
												<option>Monitor</option>
												<option>Speakers</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Model</label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Model" name="model" >
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Serial #</label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" name="serialNumber" >
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">PO #</label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" name="purchaseOrder" >
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Unit Cost</label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" name="unitCost" >
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Location</label>
										<div class="col-md-9">
											<select class="form-control" name="location">
												<option disabled selected value> -- Select an option -- </option>
												<option value="South Plainfield, NJ">South Plainfield, NJ</option>
												<option value="New Brunswick, NJ">New Brunswick, NJ</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Building</label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" name="building" >
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Room</label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" name="roomNumber" >
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Operating System</label>
										<div class="col-md-9">
											<select class="form-control" name="softwareOs">
												<option disabled selected value> -- Select an option -- </option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Description</label>
										<div class="col-md-9">
											<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" name="description" >
										</div>
									</div>
									<div class="form-actions">
										<div class="row">
											<div class="col-md-offset-3 col-md-9">
												<button type="submit" class="btn blue">Save</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- END SAMPLE FORM PORTLET-->
				<!-- end asset entry panel -->
				<div class="col-md-7">
				 	<!-- assignment panel -->
				 	<div class="row">
				 		<div class="col-md-12">
				 			<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
								<div class="portlet-title">
									<div class="caption">
										<span class="caption-subject font-blue-sharp bold uppercase">Asset Assignment</span>
									</div>
								</div>
								<div class="portlet-body form">
									<form class="form-horizontal" role="form" action="AssetAssignment.jsp" method="POST">
										<div class="form-body">
										<div class="form-group">
											<label class="col-md-3 control-label">Asset Tag<span style="color:red"> *</span></label>
											<div class="col-md-9">
												<select class="form-control" name="assetId" required>
													<option disabled selected value> -- Select an option -- </option>
													<%
														AssetDAO assetDAO = new AssetDAO();
														List assetList = assetDAO.retrieve();
														for(Iterator iterator = assetList.iterator(); iterator.hasNext(); ){
															Asset asset = (Asset) iterator.next();
													%>
															<option value="<%= asset.getId()%>"><%= asset.getAssetTag() %></option>
													<%
														}
													%>
												</select>
											</div>
										</div>
											<div class="form-group">
												<label class="col-md-3 control-label">Assign to<span style="color:red"> *</span></label>
												<div class="col-md-9">
													<select class="form-control" name="userId" required>
														<option disabled selected value> -- Select an option -- </option>
														<%
														AccountDAO accountDAO = new AccountDAO();
														List accountList = accountDAO.retrieve();
														for(Iterator iterator = accountList.iterator(); iterator.hasNext(); ){
															Account account = (Account) iterator.next();
													%>
															<option value="<%= account.getId() %>"><%= account.getFirstName() + " " + account.getLastName() %></option>
													<%
														}
													%>
													</select>
												</div>
											</div>
											<div class="form-actions">
												<div class="row">
													<div class="col-md-offset-3 col-md-9">
														<button type="submit" class="btn blue">Save</button>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							<!-- END SAMPLE FORM PORTLET-->
				 			</div>
				 		</div>
				 	</div>
				 	<!-- repair panel -->
				 	<div class="row">
				 		<div class="col-md-12">
				 		<!-- BEGIN SAMPLE FORM PORTLET-->
							<div class="portlet light">
								<div class="portlet-title">
									<div class="caption">
										<span class="caption-subject font-blue-sharp bold uppercase">Repair</span>
									</div>
								</div>
								<div class="portlet-body form">
									<form class="form-horizontal" role="form">
										<div class="form-body">
											<div class="form-group">
												<label class="col-md-3 control-label">Repair Company <span style="color:red">*</span></label>
												<div class="col-md-9">
													<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" required>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label">Ticket # <span style="color:red">*</span></label>
												<div class="col-md-9">
													<input type="text" class="form-control input-inline input-medium" placeholder="Enter text" required>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label">Comments</label>
												<div class="col-md-9">
													<input type="text" class="form-control input-inline input-medium" placeholder="Enter text">
												</div>
											</div>
											<div class="form-actions">
												<div class="row">
													<div class="col-md-offset-3 col-md-9">
														<button type="submit" class="btn blue">Save</button>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<!-- END SAMPLE FORM PORTLET-->
				 		</div>
				 	</div>
				</div>
			</div>
		</div>
		<!-- END PAGE CONTENT INNER -->
	</div>
</div>
<!-- END PAGE CONTAINER -->

<%@include file="Footer.jsp"%>

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

	$("#header").load("Header.html");
	$("#footer").load("Footer.html");
});

</script>
</body>
<!-- END BODY -->
</html>