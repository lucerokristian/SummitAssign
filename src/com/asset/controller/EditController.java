package com.asset.controller;

import java.io.IOException;

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
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static String USERMAINTENANCEEDIT = "/UserMaintenanceEdit.jsp";  
	 private static String USERMAINTENANCE = "/UserMaintenanceS.jsp";  
	 
	 AccountDao adao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
         adao = new  AccountDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
	        String action = request.getParameter("action");
	        if (action.equalsIgnoreCase("updateaccount")){
	            forward = USERMAINTENANCEEDIT;
	            String empid=request.getParameter("userId");
	    		Account account = adao.getEmploye(empid);   
	    		request.setAttribute("asset", account);	        }
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response); 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account acc = new Account();
		String uname=request.getParameter("username");
		System.out.println(uname);
		acc.setUsername(request.getParameter("username"));
		String mail=request.getParameter("email");
		System.out.println(mail);
		acc.setEmail(request.getParameter("email"));
		String role=request.getParameter("role");
		System.out.println(role);
		acc.setRole(request.getParameter("role"));
		adao.checkAccount(acc);
		RequestDispatcher view = request.getRequestDispatcher(USERMAINTENANCE);
        request.setAttribute("users", adao.getUsers());
        view.forward(request, response);
	}

}
