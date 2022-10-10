package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webdemo.bean.Encapsulatedclass;

public class EmployeeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
public EmployeeServlet() {
	super();
}
protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	response.setContentType("text/html");
	HttpSession session = request.getSession(); 
	Object obj =session.getAttribute("EmployeeObject");
	Encapsulatedclass emp = null;
	if(obj!=null) {
		emp = (Encapsulatedclass)obj;
	}
	
	
	PrintWriter pw = response.getWriter();
	pw.print("<html><body><table>");
	pw.print("<tr><th>EmplooyeeId</th><th>Employee Name</th><th>MobileNumber</th></th><th>Education</th></th><th>DateOfBirth</th></th><th>AccountName</th><th>BankName</th></th><th>Company</th><th>Designation</th></th><th>Manager</th><th>SalaryBand</th></th><th>Location</th></tr>");
    pw.print("<tr><td>"+emp.getId()+"</td>");
   pw.print("<td>"+emp.getName()+"</td>");
   pw.print("<td>"+emp.getMobile()+"</td>");
	pw.print("<td>"+emp.getEducation()+"</td>");
	    pw.print("<td>"+emp.getDob()+"</td>");
	  pw.print("<td>"+emp.getAccount()+"</td>");
	   pw.print("<td>"+emp.getBank()+"</td>");
	  pw.print("<td>"+emp.getCompany()+"</td>");
   pw.print("<td>"+emp.getRole()+"</td>");
	  pw.print("<td>"+emp.getManager()+"</td>");
	  pw.print("<td>"+emp.getSalarybase()+"</td>");
      pw.print("<td>"+emp.getLocation()+"</td></tr>");

	pw.print("<tr><td><button><a href='Index.html'>Homepage</a></td></tr>");

	pw.print("</table></body></html>");
	
	
}
	
}
