package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webdemo.bean.Encapsulatedclass;
import com.webdemo.implementation.WebImplementation;

//@webServlet("/DemoServelet")
public class DemoServelet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public DemoServelet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form submitted on GET");
		String employeeId = request.getParameter("employeeId");
		int id = 0;
		try {
			id = Integer.parseInt(employeeId);
		}catch(Exception e) {
			id = 0;
		}
		String employeeName = request.getParameter("employeeName");
		String Salarybase = request.getParameter("SalaryBand");
		String mobile = request.getParameter("MobileNo");
		long mob = 0;
		try {
			mob = Long.parseLong(mobile);
		}catch(Exception e) {
			mob = 0;
		}
	 String Education = request.getParameter("Education");
     String dob = request.getParameter("Date of birth");
     String account = request.getParameter("Account no.");
     long ac = 0;
     try {
    	 ac = Long.parseLong(account);
     }catch(Exception e) {
    	 ac = 0;
     }
	 String bank=request.getParameter("Bank Name");
	 String company = request.getParameter("Company Name");
	 String role = request.getParameter("Designation");
     String Manager = request.getParameter("Manager");
	String location = request.getParameter("Location");
		
		Encapsulatedclass es = new Encapsulatedclass();
		es.setId(id);
		es.setName(employeeName);
		es.setMobile(mob);
		es.setAccount(ac);
		es.setBank(bank);
		es.setCompany(company);
		es.setDob(dob);
		es.setEducation(Education);
		es.setLocation(location);
		es.setManager(Manager);
		es.setRole(role);
		es.setSalarybase(Salarybase);
		
		WebImplementation we = new WebImplementation();
		int result = we.Insertwithprepst(es);
		HttpSession session = request.getSession();
		session.setAttribute("EmployeObject", es);
		
		RequestDispatcher empservlet = request.getRequestDispatcher("/EmployeeData");
		RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
		if(result>0) {
			empservlet.forward(request, response);
		} else {
			failure.forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Submitted on post");
		String employeeId = request.getParameter("employeeId");
		int id = 0;
		try {
			id = Integer.parseInt(employeeId);
		}catch(Exception e) {
			id = 0;
		}
		
		Encapsulatedclass ec = new Encapsulatedclass();
		ec.setId(id);
		
		WebImplementation wi = new WebImplementation();
		int result = wi.deletest(ec);
		RequestDispatcher success = request.getRequestDispatcher("success.html");
		RequestDispatcher failure = request.getRequestDispatcher("failue.html");
		if(result>0) {
			success.forward(request, response);
		}else {
			failure.forward(request, response);
		}
		
	}

}
