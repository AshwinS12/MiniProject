package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webdemo.bean.Encapsulatedclass;
import com.webdemo.implementation.WebImplementation;

public class SelectData extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public SelectData() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		WebImplementation dao = new WebImplementation();
		List<Encapsulatedclass> result = dao.Fetch();
		
		HttpSession session = request.getSession();
		session.setAttribute("EmployeeObject", result);
		
		//RequestDispatcher req = request.getRequestDispatcher("view.html");
		RequestDispatcher req = request.getRequestDispatcher("/EmployeeData");
		req.forward(request, response);
	}
}
