<%@ page import="project.AssetDAO" %>
<%@ page import="project.Asset" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>Dashboard | Home</title>
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
<%if(session == null || !request.isRequestedSessionIdValid()){%>
	<jsp:forward page="Login.html"/>
<%}else{
	if((session.getAttribute("isAdmin")).equals(true)){ %>
<%@include file="Header.jsp"%>
<% }else{ %>
<%@include file="HeaderAuthorizedUser.jsp"%>
<% } 
}%>
<%
AssetDAO assetDAO = new AssetDAO();
List active = null; List inactive = null; List repair = null;
active = assetDAO.retrieveByStatus(1);
inactive = assetDAO.retrieveByStatus(2);
repair = assetDAO.retrieveByStatus(3);
%>
<label style="display:none" id="active" value="<%= active.size() %>"><%= active.size() %></label>
<label style="display:none" id="inactive" value="<%= inactive.size() %>"><%= inactive.size() %></label>
<label style="display:none" id="repair" value="<%= repair.size() %>"><%= repair.size() %></label>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container" style="background-color:whitesmoke">
	
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>Home</h1>
			</div>
			<!-- END PAGE TITLE -->
		</div>
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
		<div class="container" style="margin-top:1%">
			<!-- BEGIN PAGE CONTENT INNER -->
			<div class="row">
				<div class="col-md-12">
					 <div class="col-md-3">
						 <!-- BEGIN BASIC CHART PORTLET-->
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption">
									<span class="caption-subject font-blue-sharp bold uppercase">Total Assets by Status</span>
								</div>
							</div>
							<div class="portlet-body">
								<div id="chart_1_1_legendPlaceholder">
								</div>
								<div id="assetsChart" class="chart">
								</div>
							</div>
						</div>
						<form class="form-horizontal" role="form" action="FilterTable.jsp" method="POST">
							<div class="form-body">
								<div class="form-group">
									<label class="col-md-3 control-label">Filter: </label>
									<div class="col-md-9">
										<select class="form-control" name="status" required>
											<option disabled selected value> -- Select an option -- </option>
											<option value="1">Active</option>
											<option value="2">Inactive</option>
											<option value="3">Repair</option>
										</select>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn blue">Filter</button>
										</div>
									</div>
								</div><br>
							</div>
						</form>
						<br>
						<!-- END BASIC CHART PORTLET-->
					 </div>
					 <div class="col-md-6">
						 <!-- BEGIN SAMPLE TABLE PORTLET-->
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption">
									<span class="caption-subject font-blue-sharp bold uppercase">Assets</span>
								</div>
							</div>
							<div class="portlet-body">
								<div class="table-scrollable">
									<table class="table table-hover">
									<thead>
										<tr>
											<th>
												 Asset Tag
											</th>
											<th>
												 Model
											</th>
											<th>
												 Type
											</th>
											<th>
												 Serial #
											</th>
											<th>
												 Purchase Order #
											</th>
										</tr>
									</thead>
									<tbody>
									<%
										List assetList = null;
										List assetListSecond = null;
										if(request.getParameter("status") == null){
											assetList = assetDAO.retrieveByStatus(1);
											assetListSecond = assetDAO.retrieveNoDuplicate(1);
										}
										else{
											assetList = assetDAO.retrieveByStatus(Integer.parseInt(request.getParameter("status")));
											assetListSecond = assetDAO.retrieveNoDuplicate(Integer.parseInt(request.getParameter("status")));
										}
										for(Iterator iterator = assetList.iterator(); iterator.hasNext(); ){
											Asset asset = (Asset) iterator.next();
									%>
										<tr>
											<td>
												 <%= asset.getAssetTag() %>
											</td>
											<td>
												<%= asset.getModel() %>
											</td>
											<td>
												<%= asset.getAssetType() %>
											</td>
											<td>
												 <%= asset.getSerialNumber() %>
											</td>
											<td>
												<%= asset.getPurchaseOrder() %>
											</td>
										</tr>
									<%
										}
									%>
									</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- END SAMPLE TABLE PORTLET-->
					 </div>
					 <div class="col-md-3">
					 	<!-- BEGIN Portlet PORTLET-->
					 	<%
					 		String color[] = {"green-meadow", "red-sunglo", "blue-madison", "yellow-crusta"};
					 		int i = 0;
							for(Iterator iterator = assetListSecond.iterator(); iterator.hasNext();){
								Asset asset = (Asset) iterator.next();
					 	%>
							<div class="portlet box <%= color[i++] %>">
								<div class="portlet-title">
									<div class="caption">
										<%= asset.getAssetType() %>
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse">
										</a>
									</div>
									
								</div>
								<div class="portlet-body">
									 Total: <%= assetDAO.getAssetCount(asset.getAssetType()) %> <br> Assigned: <%= assetDAO.getAssetAssigned(asset.getAssetType()) %>
								</div>
							</div>
						<%
						if(i == 4)
							i = 0;
						} %>
						<!-- END Portlet PORTLET-->
					 </div>
				</div>
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<%@include file="Footer.jsp"%>
	<!-- END PAGE CONTENT -->
<!-- END PAGE CONTAINER -->


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
	Layout.init(); //  init current layout
	Demo.init(); // init demo features              	
});

$(document).ready(function(){
	function barChart(){
		var data = GenerateSeries(0);
	    function GenerateSeries(added) {
	        var data = [];
	        data.push([0, $('#active').text()]);
	        data.push([1, $('#inactive').text()]);
	        data.push([2, $('#repair').text()]);
	        return data;
	    }
	
	    var options = {
	        series: {
	            bars: {
	                show: true
	            }
	        },
	        bars: {
	            barWidth: 0.8,
	            lineWidth: 0, // in pimxels
	            shadowSize: 0,
	            align: 'center'
	        },
	        
	        xaxis: {
	        	ticks: [[0,"Active"],[1,"Inactive"],[2,"Repair"]]
	        },
	        
	        grid: {
	            tickColor: "#eee",
	            borderColor: "#eee",
	            borderWidth: 1
	        }
	    };
	
	    if ($('#assetsChart').size() !== 0) {
	        $.plot($("#assetsChart"), [{
	            data: data,
	            lines: {
	                lineWidth: 1,
	            },
	            shadowSize: 0
	        }], options);
	    }
	}

	barChart();
});

</script>
</body>
<!-- END BODY -->
</html>