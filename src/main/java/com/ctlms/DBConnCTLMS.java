package com.ctlms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnCTLMS {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    private static final Logger LOGGER = Logger.getLogger(DBConnCTLMS.class.getName());

    public DBConnCTLMS(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }
}
