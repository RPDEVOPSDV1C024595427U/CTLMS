package com.ctlms;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBConnCTLMSTest {
	
    @Test
    public void testGetConnection() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnCTLMS.getConnection();
        Assert.assertNotNull("Connection should not be null", connection);
        connection.close();
    }
}
