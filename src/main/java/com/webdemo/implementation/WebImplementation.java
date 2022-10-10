package com.webdemo.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
String query = "delete from encapsulatedclass where id= "+ec.getId()+";";
try {
	state = connect.createStatement();
	result = state.executeUpdate(query); 
/*	int result = 0;
	String query = "delete from encapsulatedclass where id = ?";	
	try {
		pstate = connect.prepareStatement(query);
		pstate.setInt(1,ec.getId() );
		result = pstate.executeUpdate(); */
} catch (SQLException e) {
	e.printStackTrace();
}
return result;
}
public int UpdatewithprepstName(Encapsulatedclass ec) {
	int result = 0;
	
	String query = "update encapsulatedclass set name =? , role =? , salarybase =?  where id = ?";
	try {
		pstate = connect.prepareStatement(query);
		
		pstate.setString(1, ec.getName());
		pstate.setString(2, ec.getRole());
		 pstate.setString(3, ec.getSalarybase());
		 pstate.setInt(4,ec.getId() );
	result = pstate.executeUpdate();
	}catch(SQLException e) {
		System.out.println(e);
	}
	return result;
}

public Encapsulatedclass Searchst(String ec) {
	Encapsulatedclass result = null;
	String query = "select * from encapsulatedclass where id = ?";	
	try {
		pstate = connect.prepareStatement(query);
		pstate.setString(1,ec);
		resultset = pstate.executeQuery();
		while(resultset.next()) {
			result = new Encapsulatedclass();
			result.setId(resultset.getInt(1));
			result.setName(resultset.getString(2));
			result.setMobile(resultset.getLong(3));
			result.setEducation(resultset.getString(4));
			result.setDob(resultset.getString(5));
			result.setAccount(resultset.getLong(6));
			result.setBank(resultset.getString(7));
			result.setCompany(resultset.getString(8));
			result.setRole(resultset.getString(9));
			result.setManager(resultset.getString(10));
			result.setSalarybase(resultset.getString(11));
			result.setLocation(resultset.getString(12));	
		}
		
		} 
		
	 catch (SQLException e) {
		e.printStackTrace();
	}
	return result;
	}

public List<Encapsulatedclass> Fetch() {
	List<Encapsulatedclass> listofemp = new ArrayList<Encapsulatedclass>();
	String query = "select * from encapsulatedclass";	
	try {
		pstate = connect.prepareStatement(query);

		resultset = pstate.executeQuery();
		Encapsulatedclass result = null;
		while(resultset.next()) {
			result = new Encapsulatedclass();
			result.setId(resultset.getInt(1));
			result.setName(resultset.getString(2));
			result.setMobile(resultset.getLong(3));
			result.setEducation(resultset.getString(4));
			result.setDob(resultset.getString(5));
			result.setAccount(resultset.getLong(6));
			result.setBank(resultset.getString(7));
			result.setCompany(resultset.getString(8));
			result.setRole(resultset.getString(9));
			result.setManager(resultset.getString(10));
			result.setSalarybase(resultset.getString(11));
			result.setLocation(resultset.getString(12));
			listofemp.add(result);
		}
		
		} 
		
	 catch (SQLException e) {
		e.printStackTrace();
	}
	return listofemp;
	}
}
