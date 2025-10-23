package com.ToAndFro.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcConnectionFactory.class);
    private final static String URL = ConfigLoader.getDBUrl();
    private final static String USERNAME = ConfigLoader.getDBUserName();
    private final static String PASSWORD = ConfigLoader.getDBPassword();
    private final static String DRIVER = ConfigLoader.getDBDriver();
    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (JdbcConnectionFactory.class) {
                if (connection == null || connection.isClosed())

                    LOGGER.debug("Attempting to create DB connection to: {}", URL);
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                if (connection != null) {
                    LOGGER.debug("DB connection established successfully");
                } else {
                    LOGGER.warn("Failed to establish DB connection");
                }
            }
        }
        return connection;
    }
}
