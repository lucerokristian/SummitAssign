package com.asset.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asset.dao.AssetDao;

/**
 * Servlet implementation class MoveAsset
 */
@WebServlet("/MoveAsset")
public class MoveAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AssetDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveAsset() {
        super();
        dao = new AssetDao();
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
		// TODO Auto-generated method stub
		String assetid=request.getParameter("assetid");
		System.out.println(assetid);
		String finalroom=request.getParameter("finalroom");
		System.out.println(finalroom);
		dao.updateAssetRoom(assetid,finalroom);
		RequestDispatcher view = request.getRequestDispatcher("/UserMaintenanceS.jsp");
		view.forward(request, response);
	}

}
