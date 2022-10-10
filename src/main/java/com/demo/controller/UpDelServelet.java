package com.demo.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webdemo.bean.Encapsulatedclass;
import com.webdemo.implementation.WebImplementation;

public class UpDelServelet extends HttpServlet {


	private static final long serialVersionUID = 1L;

public UpDelServelet() {
	super();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
	System.out.println("form update in Post");
	String employeeId = request.getParameter("employeeId");
	int id = 0;
	try {
		id = Integer.parseInt(employeeId);
	}catch(Exception e) {
		id = 0;
	}
	String name = request.getParameter("name");
	String Salarybase = request.getParameter("salaryband");
	String role = request.getParameter("role");
	Encapsulatedclass es = new Encapsulatedclass();
	es.setId(id);
	es.setName(name);
    es.setSalarybase(Salarybase);
	es.setRole(role);
	WebImplementation we = new WebImplementation();
	
	int result = we.UpdatewithprepstName(es);
	HttpSession session = request.getSession();
	session.setAttribute("EmployeeObject", es);

	RequestDispatcher success = request.getRequestDispatcher("successfull.html");
	RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
	if(result>0) {
		success.forward(request, response);
	}else {
		failure.forward(request, response);
	}
}

	/* String val = request.getParameter("result");
	int vl = Integer.parseInt(val);
	Encapsulatedclass es = new Encapsulatedclass();
	es.setId(id);
	WebImplementation we = new WebImplementation();
	switch(vl) {
	case 1:  result = we.UpdatewithprepstName(es);
	break;
	case 2:  result = we.UpdatewithprepstDesignation(es);
	break;
	case 3 : result = we.UpdatewithprepstSalary(es);
	break;
	default: System.out.println("Not supported");
	} */

	
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	System.out.println("This is search in get");
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
	Encapsulatedclass ee = wi.Searchst(employeeId);
	HttpSession session = request.getSession();
	session.setAttribute("EmployeeObject", ee);
	RequestDispatcher success = request.getRequestDispatcher("/EmployeeData");
	RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
	if(ee!=null) {
		success.forward(request, response);
	}else {
		failure.forward(request, response);
	}
}

}



