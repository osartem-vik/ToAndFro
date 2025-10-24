package com.ToAndFro.configs;

import com.ToAndFro.exceptions.ConfigFileNotFoundException;
import com.ToAndFro.exceptions.ConfigLoadingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(JDBCConnectionFactory.class);
    private static final JDBCConnectionFactory INSTANCE = new JDBCConnectionFactory();
    private final Properties properties;
    private final static String CONFIG_FILE = "app.properties";
    private final static String DB_URL = "db.url";
    private final static String DB_USER = "db.username";
    private final static String DB_PASS = "db.password";
    private final static String DB_DRV = "db.driver";
    private static volatile Connection connection;


    private JDBCConnectionFactory() {
        this.properties = new Properties();
        try (InputStream input = JDBCConnectionFactory.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new ConfigFileNotFoundException("Unable to find application.properties");
            }
            properties.load(input);
            LOGGER.info("Configuration loaded successfully");
        } catch (IOException ex) {
            LOGGER.error("Error loading config", ex);
            new ConfigLoadingException("Error loading config", ex);
        }
        try {
            String driver = getDbDriver();
            Class.forName(driver);
            LOGGER.info("JDBC Driver loaded successfully: {}", driver);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Failed to load JDBC Driver: {}", getDbDriver(), e);
            throw new RuntimeException("JDBC Driver not found: " + getDbDriver(), e);
        }
    }

    public static JDBCConnectionFactory getInstance() {
        return INSTANCE;
    }


    public String getDbUrl() {
        return properties.getProperty(DB_URL);
    }

    public String getDbUsername() {
        return properties.getProperty(DB_USER);
    }

    public String getDbPassword() {
        return properties.getProperty(DB_PASS);
    }

    public String getDbDriver() {
        return properties.getProperty(DB_DRV);
    }

    public Connection getConnection() throws SQLException {
        String url = getDbUrl();
        String username = getDbUsername();
        String password = getDbPassword();
        if (connection == null || connection.isClosed()) {
            synchronized (JDBCConnectionFactory.class) {
                if (connection == null || connection.isClosed()) {
                    LOGGER.debug("Attempting to create DB connection to: {}", url);
                    connection = DriverManager.getConnection(url, username, password);
                    if (connection != null) {
                        LOGGER.debug("DB connection established successfully");
                    } else {
                        LOGGER.warn("Failed to establish DB connection");
                    }

                }
            }
        }
        return connection;
    }
}