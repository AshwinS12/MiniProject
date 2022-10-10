package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webdemo.bean.Encapsulatedclass;

public class EmployeeData extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public EmployeeData() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(); 
		Object obj =session.getAttribute("EmployeeObject");
		Encapsulatedclass emp = null;
		if(obj!=null) {
			emp = (Encapsulatedclass)obj;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/EmployeeServlet");
		session.setAttribute("EmployeeData", rd);
		PrintWriter out = response.getWriter();
		out.print("<html><body><table>");
		//out.print("<tr><th>id")
		//out.print("<td>"+emp.getid()+"</td>");
		out.print("<button>");
		out.print("<a href='EmployeeServlet'>Data</a>");
		out.print("</button>");
		out.print("</table></body></html>");
		
	}
	
}
