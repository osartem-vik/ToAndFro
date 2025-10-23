package com.ToAndFro.configs;

import com.ToAndFro.exceptions.ConfigFileNotFoundException;
import com.ToAndFro.exceptions.ConfigLoadingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private final static Logger LOGGER = LoggerFactory.getLogger(ConfigLoader.class);
    private static Properties properties;
    private final static String CONFIG_FILE = "app.properties";
    private final static String DB_URL = "db.url";
    private final static String DB_USER = "db.username";
    private final static String DB_PASS = "db.password";
    private final static String DB_DRV = "db.driver";

    private static final ConfigLoader INSTANCE = new ConfigLoader();

    private ConfigLoader() {
        this.properties = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new ConfigFileNotFoundException("Unable to find a file with properties");
            }
            properties.load(input);
            LOGGER.info("Configuration loaded successfully");
        } catch (IOException ex) {
            LOGGER.error("Error loading config", ex);
            new ConfigLoadingException("Error loading config", ex);
        }
    }

    public static ConfigLoader getInstance() {
        return INSTANCE;
    }

    public static String getDBUrl() {
        return properties.getProperty(DB_URL);
    }

    public static String getDBUserName() {
        return properties.getProperty(DB_USER);
    }

    public static String getDBPassword() {
        return properties.getProperty(DB_PASS);
    }

    public static String getDBDriver() {
        return properties.getProperty(DB_DRV);
    }
}
