package com.company.elbek.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomConnector {

    public Connection getConnection(String url, String user, String password) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}