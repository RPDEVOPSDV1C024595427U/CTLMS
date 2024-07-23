package com.ctlms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnCTLMS {
	
	private static final String jdbcURL = System.getenv("DB_URL");
	private static final String  jdbcUsername = System.getenv("DB_USERNAME");
	private static final String jdbcPassword = System.getenv("DB_PASSWORD");
	
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
