package com.webdemo.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysqldbconnect.MySqlConnection;
import com.webdemo.bean.Encapsulatedclass;

public class WebImplementation {
Connection connect;
PreparedStatement pstate;
Statement state;
ResultSet resultset;

public WebImplementation() {
	connect = MySqlConnection.getInstance();
}

public int Insertwithprepst(Encapsulatedclass ec) {
	int result = 0;
	String query = "insert into encapsulatedclass values(?,?,?,?,?,?,?,?,?,?,?,?)";	
	try {
		pstate = connect.prepareStatement(query);
		pstate.setInt(1,ec.getId() );
		pstate.setString(2, ec.getName());
		pstate.setLong(3,ec.getMobile());
		pstate.setString(4, ec.getEducation());
		pstate.setString(5, ec.getDob());
		pstate.setLong(6, ec.getAccount());
		pstate.setString(7, ec.getBank());
		pstate.setString(8, ec.getCompany());
		pstate.setString(9, ec.getRole());
	    pstate.setString(10, ec.getManager());
	    pstate.setString(11, ec.getSalarybase());
	    pstate.setString(12, ec.getLocation());
	result = pstate.executeUpdate();
	}catch(SQLException e) {
		System.out.println(e);
	}
	
	return result;
	
}

public int deletest(Encapsulatedclass ec) {
	int result = 0;
String query = "delete from Encapsulatedclass where id= "+ec.getId();
try {
	state = connect.createStatement();
	result = state.executeUpdate(query);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return result;
}

	
}
