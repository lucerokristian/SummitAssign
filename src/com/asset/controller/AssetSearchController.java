package com.asset.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asset.dao.AssetDao;
import com.asset.model.Asset;

/**
 * Servlet implementation class AssetSearchController
 */
@WebServlet("/AssetSearchController")
public class AssetSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ASSETSEARCH="/AssetSearch.jsp";
	AssetDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetSearchController() {
        super();
        dao= new AssetDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String forward="";
		
		
		if(action.equalsIgnoreCase("assetSearch")){
			forward=ASSETSEARCH;
			String assettype=request.getParameter("assettype");
    		
    		
    	List<Asset> assets=dao.assetSearch(assettype);
        request.setAttribute("asset",assets );
        System.out.println("out of servlet");
    	}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response); 
	}

}
