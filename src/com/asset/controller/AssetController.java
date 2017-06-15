package com.asset.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asset.dao.*;
import com.asset.dao.AssetAssignedDao;
import com.asset.model.*;
import com.asset.model.Asset;
import com.asset.model.Account;
import com.asset.model.AssetAssigned;

/**
 * Servlet implementation class AssetController
 */
/*@WebServlet("/AssetController")*/
public class AssetController extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	private AssetDao dao;
	private AccountDao adao;
	private AssetAssignedDao aadao;
	 private static String ASSET_SEARCH = "/AssetSearch12.jsp";
	 private static String REPORTBYUSERNAME = "/ReportByUsernameB.jsp";
	 private static String REPORTSTATUS = "/ReportByStatusB.jsp";
	 private static String USERMAINTENANCE="/UserMaintenance.jsp";
	 private static String USERMAINTENANCEEDITUSER="/UserMaintenanceNewUser.jsp";
	 private static String USERMAINTENANCEATA="/UserMaintenanceMasterData.jsp";
	 private static String EDITUSER="UserMaintenanceEdit.jsp";
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetController() {
        super();
       dao=new AssetDao();
      adao = new  AccountDao();
       aadao = new AssetAssignedDao();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward="";
        String action = request.getParameter("action");
       
        if(action.equalsIgnoreCase("assetSearch")){
        	forward =  ASSET_SEARCH ;
        	String assettype=request.getParameter("assettype");
            request.setAttribute("asset", dao.assetSearch(assettype));
        }
        
        
        
        else if (action.equalsIgnoreCase("usermaintenance")){
        	System.out.println("controller");
        	forward=USERMAINTENANCE;
        	
        	System.out.println("forwading");
            request.setAttribute("user",adao.getUsers() );
        }
        
        else if (action.equalsIgnoreCase("masterdata")){
        	System.out.println("controller");
        	forward=USERMAINTENANCEATA;
        	
        	System.out.println("forwading");
            request.setAttribute("user",dao.getAsset() );
        }
        
        else if(action.equalsIgnoreCase("updateaccount")){
    		forward=EDITUSER;
    		String empid=request.getParameter("userId");
    		Account account = adao.getEmploye(empid);   
    		request.setAttribute("user", account);
    	}
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response); 
	
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		
    	
    	String action=request.getParameter("action");//Reportbyusername
    	/*String reportstatus=request.getParameter("btnreportstatus");//getting parameter from reportByStatus
    	String reportstatusselect=request.getParameter("status");*/
    	/*System.out.println(reportstatus);
    	System.out.println(reportstatusselect);*/
    	
    	//System.out.println(formname);
    	//System.out.println(username);
    	if(action.equalsIgnoreCase("report")){
    		forward=REPORTBYUSERNAME;
    		String username=request.getParameter("username");
    	List<Asset> assets=aadao.AssetByUsername(username);
        request.setAttribute("asset",assets );
    	}
    	
    	else if(action.equalsIgnoreCase("reportbystatus")){
    		forward=REPORTSTATUS;
    		String status=request.getParameter("status");
    		List<Asset> assets=aadao.getReportByStatus("status");
    		request.setAttribute("asset",assets );
    	}
    	
    	
    	
    	else if(action.equalsIgnoreCase("saveuser")){
    		forward=USERMAINTENANCEEDITUSER;
    		System.out.println(action);
    		String firstname=request.getParameter("firstname");
    		String lastname=request.getParameter("lastname");
    		String username=request.getParameter("username");
    		String password=request.getParameter("password");
    		String email=request.getParameter("email");
    		String role=request.getParameter("role");
    		System.out.println(role);
    		adao.insertUser(firstname,lastname,username,password,email,role);
    		System.out.println("sdfghjdfgb");
    		
    	}
    	else if(action.equalsIgnoreCase("moveasset")){
    		
    		String assetid=request.getParameter("assetid");
    		System.out.println(assetid);
    		String finalroom=request.getParameter("finalroom");
    		System.out.println(finalroom);
    		dao.updateAssetRoom(assetid,finalroom);
    		
    		
    	}
    	
    	
    	
    		
    	
    	
        RequestDispatcher view = request.getRequestDispatcher(forward);
        
        view.forward(request, response);
	}

}
