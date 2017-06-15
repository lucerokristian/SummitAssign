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
	</head>
	<body class="page-md">
	<%@include file="Header.jsp"%>
		<div class="page-container">
			<div class="pager-header">
				<div class="page-title">
					<h1><small>Asset Move</small></h1>
				</div>
			</div>
			<!--END OF PAGE HEADER-->
			<div class="container">
	 			 <div class="col-md-12">
					<div class="portlet light">
						<div class="portlet-body form">
							<form role="form" class="form-horizontal" method="post" action="MoveAsset">
								<div class="form-body">
									<!-- <div class="form-group ">
										<label class="col-md-2 control-label" for="form_control_1">Select Room</label>
										<div class="col-md-10">
											<select class="form-control" id="form_control_1" name="initialroom">
												<option value="111">111A</option>
												<option value="112">112A</option>
												<option value="113">113A</option>	
											</select>
										</div>
									</div> -->
									<!--select room-->
									<div class="form-group  ">
										<label class="col-md-2 control-label" for="form_control_1">Asset ID</label>
										<div class="col-md-10">
											<input type="text" class="form-control" id="form_control_1" placeholder="Asset Tag" name="assetid">
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<!--Asset Tag-->
									<div class="form-group ">
										<label class="col-md-2 control-label" for="form_control_1">Move a Room</label>
										<div class="col-md-10">
											<select class="form-control" id="form_control_1" name="finalroom">
												<option value="111">111A</option>
												<option value="112"> 112A</option>
												<option value="113"> 113A</option>	
											</select>
										</div>
									</div>
									<!--Move a room-->
									<div class="form-actions">
										<div class="row">
											<div class="col-md-offset-2 col-md-10">
												<a href="UserMaintenanceS.jsp">
													<button type="button" class="btn default">Cancel</button>
												</a>
												<button type="submit" class="btn blue" >Save</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>			
					</div>
				</div>
			</div>
		</div>
		<!--container-->
	<%@include file="Footer.jsp"%>
	</body>	
</html>

					