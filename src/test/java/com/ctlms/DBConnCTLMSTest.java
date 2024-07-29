package com.ctlms;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class DBConnCTLMSTest {
	
    @Mock
    private Connection mockConnection;
	
    String jdbcURL = System.getenv("DB_URL");
    String jdbcUsername = System.getenv("DB_USERNAME");
    String jdbcPassword = System.getenv("DB_PASSWORD");
    private DBConnCTLMS dbConnCTLMS = new DBConnCTLMS(jdbcURL, jdbcUsername, jdbcPassword);

    @Before
    public void setUp() {
        dbConnCTLMS = new DBConnCTLMS(jdbcURL, jdbcUsername, jdbcPassword);
    }
    	
    @Test
    public void testGetConnectionSuccess() throws SQLException, ClassNotFoundException {
        try (Connection connection = dbConnCTLMS.getConnection()) {
            assertNotNull("Connection should not be null", connection);
        }
    }

    @Test
    public void testGetConnectionSQLException() throws SQLException, ClassNotFoundException {
        DBConnCTLMS dbConnCTLMS = spy(new DBConnCTLMS(jdbcURL, jdbcUsername, jdbcPassword));
        doThrow(new SQLException("Mock SQL Exception")).when(dbConnCTLMS).getConnection();
        
        SQLException thrown = assertThrows(
                SQLException.class,
                dbConnCTLMS::getConnection
        );
        
        assertEquals("Mock SQL Exception", thrown.getMessage());
    }

    @Test
    public void testGetConnectionClassNotFoundException() throws SQLException, ClassNotFoundException {
        DBConnCTLMS dbConnCTLMS = spy(new DBConnCTLMS(jdbcURL, jdbcUsername, jdbcPassword));
        doThrow(new ClassNotFoundException("Mock ClassNotFoundException")).when(dbConnCTLMS).getConnection();
        
        ClassNotFoundException thrown = assertThrows(
                ClassNotFoundException.class,
                dbConnCTLMS::getConnection
        );
        
        assertEquals("Mock ClassNotFoundException", thrown.getMessage());
    }
}
