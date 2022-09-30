package com.mysqldbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
static MySqlConnection mysql = new MySqlConnection();
static  Connection connection;

private MySqlConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","ashwin2892");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static Connection getInstance() {
	return mysql.connection;
}

	public static void main(String[] args) {
		System.out.println(MySqlConnection.getInstance());
	}

}
