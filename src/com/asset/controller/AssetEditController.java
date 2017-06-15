package com.asset.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asset.dao.AssetDao;
import com.asset.dao.*;
import com.asset.model.Asset;

/**
 * Servlet implementation class AssetEditController
 */
@WebServlet("/AssetEditController")
public class AssetEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String MASTERDATAEDIT="/UserMaintenanceEditStatus.jsp";
	AssetDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetEditController() {
        super();
        dao=new AssetDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
	        String action = request.getParameter("action");
	       
	        if(action.equalsIgnoreCase("updateasset")){
	        	
		            forward = MASTERDATAEDIT;
		            String assettype=request.getParameter("assettype");
		    		Asset as =  dao.getDataEdit(assettype);   
		    		request.setAttribute("asset", as);	        
		        RequestDispatcher view = request.getRequestDispatcher(forward);
		        view.forward(request, response); 
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Asset asset = new Asset();
		String at=request.getParameter("assettype");
		System.out.println(at);
		asset.setAssetType(request.getParameter("asset_type"));
		String st =request.getParameter("status");
		System.out.println(st);
		asset.setStatus(request.getParameter("status"));
		dao.checkAsset(asset);
		
	}

}
