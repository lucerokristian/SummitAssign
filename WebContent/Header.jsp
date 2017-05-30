<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- BEGIN HEADER -->
<div class="page-header">
	<!-- BEGIN HEADER TOP -->
	<div class="page-header-top">
		<div class="container">
			<!-- BEGIN LOGO -->
			<div class="page-logo">
				<a href="Home.html"><h2>SummitAssign Logo</h2></a>
			</div>
			<!-- END LOGO -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<li class="droddown dropdown-separator">
						<span class="separator"></span>
					</li>
					<li>
						<text id="fullName"><% out.println(session.getAttribute("firstName") + " " + session.getAttribute("lastName")); %></text><br>
						<text id="role">Role: <% 
							if((session.getAttribute("isAdmin")).equals(true))
								out.println("System Administrator");
							else
								out.println("Authorized User");
						%> </text>
					</li>
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
	</div>
	<!-- END HEADER TOP -->
	<!-- BEGIN HEADER MENU -->
	<div class="page-header-menu">
		<div class="container">
			<!-- BEGIN MEGA MENU -->
			<!-- DOC: Apply "hor-menu-light" class after the "hor-menu" class below to have a horizontal menu with white background -->
			<!-- DOC: Remove data-hover="dropdown" and data-close-others="true" attributes below to disable the dropdown opening on mouse hover -->
			<div class="hor-menu ">
				<ul class="nav navbar-nav">
					<li>
						<a href="Home.jsp">
							<i class="fa fa-bank"></i>Home
						</a>
					</li>
					<li>
						<a href="AssetEntry.jsp">
							<i class="fa fa-pencil-square-o"></i>Asset Entry
						</a>
					</li>
					<li>
						<a href="Asset Search"> 
							<i class="fa fa-search"></i>
							Asset Search
						</a>
					</li>
					<li class="menu-dropdown classic-menu-dropdown ">
						<a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown">
						Reports <i class="fa fa-angle-down"></i>
						</a>
						<ul class="dropdown-menu pull-left">
							<li>
								<a href="AssetAssignedReport.html">
								Asset Assigned Report </a>
							</li>
							<li>
								<a href="AssetStatusReport.html">
								Asset Status Report </a>
							</li>
						</ul>
					</li>
					<li class="menu-dropdown classic-menu-dropdown ">
						<a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown">
						Maintenance <i class="fa fa-angle-down"></i>
						</a>
						<ul class="dropdown-menu pull-left">
							<li>
								<a href="UserMaintenance.html">
								User </a>
							</li>
							<li>
								<a href="MasterDataManagement.html">
								Master Data Management </a>
							</li>
							<li>
								<a href="ChangeAssetTag.html">
								Change Asset Tag </a>
							</li>
							<li>
								<a href="AssetMove.html">
								Asset Move </a>
							</li>
						</ul>
					</li>
					<li class="pull-right ">
						<a href="Logout.jsp">
							Logout
						</a>
					</li>
				</ul>
			</div>
			<!-- END MEGA MENU -->
		</div>
	</div>
	<!-- END HEADER MENU -->
</div>
<!-- END HEADER -->