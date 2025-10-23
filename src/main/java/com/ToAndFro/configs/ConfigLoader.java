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
    private final static String PATH_OF_PROPERTIES = "app.properties";
    private static final ConfigLoader INSTANCE = new ConfigLoader();

    private ConfigLoader() {
        this.properties = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(PATH_OF_PROPERTIES)) {
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
        return properties.getProperty("db.url");
    }

    public static String getDBUserName() {
        return properties.getProperty("db.username");
    }

    public static String getDBPassword() {
        return properties.getProperty("db.password");
    }

    public static String getDBDriver() {
        return properties.getProperty("db.driver");
    }
}
