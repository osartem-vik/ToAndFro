package com.ToAndFro.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionFactory {
    private final static Logger logger = LoggerFactory.getLogger(JdbcConnectionFactory.class);
    private final static String URL = ConfigLoader.getDBUrl();
    private final static String USERNAME = ConfigLoader.getDBUserName();
    private final static String PASSWORD = ConfigLoader.getDBPassword();
    private final static String DRIVER = ConfigLoader.getDBDriver();

    public static Connection getConnection() throws SQLException {
        logger.debug("Attempting to create DB connection to: {}", URL);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if (connection != null) {
            logger.debug("DB connection established successfully");
        } else {
            logger.warn("Failed to establish DB connection");
        }
        return connection;
    }
}
