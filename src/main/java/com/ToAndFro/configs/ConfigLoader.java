package com.ToAndFro.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (input == null)
                throw new IOException("Unable to find a file with properties");
            properties.load(input);
            logger.info("Configuration loaded successfully");
        } catch (IOException ex) {
            logger.error("Error loading config", ex);
            throw new RuntimeException("Error loading config", ex);
        }
    }
    public static String getDBUrl(){
        return properties.getProperty("db.url");
    }
    public static  String getDBUserName(){
        return properties.getProperty("db.username");
    }
    public static String getDBPassword(){
        return properties.getProperty("db.password");
    }
    public static String getDBDriver(){
        return properties.getProperty("db.driver");
    }
}
