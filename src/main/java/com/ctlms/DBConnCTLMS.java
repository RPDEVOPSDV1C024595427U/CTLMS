package com.ctlms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnCTLMS {
	
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/ctlms";
	private static final String  jdbcUsername = "root";
	private static final String jdbcPassword = "password";
	
    protected static final Connection getConnection() {
    	Connection connection = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    	} catch (SQLException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return connection;
    }

}
