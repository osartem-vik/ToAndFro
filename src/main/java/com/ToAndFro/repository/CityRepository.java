package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.CitySqlException;
import com.ToAndFro.models.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityRepository.class);
    private final String SAVE_CITY_QUERY = "INSERT INTO city(name, regionId) VALUES (?, ?)";

    private final int noChangedRows = 0;

    private void setCityParams(City city, PreparedStatement statement) throws SQLException {
        statement.setString(1, city.getName());
        statement.setLong(2, city.getRegionId());
    }

    public void save(City city) {
        try(Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CITY_QUERY);
            setCityParams(city, preparedStatement);

            int res = preparedStatement.executeUpdate();
            if (res == noChangedRows) {
                LOGGER.error("Failed saving city");
                throw new CitySqlException("Failed saving city");
            }
            LOGGER.info("City saved: {} rows affected", res);
        } catch (SQLException e) {
            LOGGER.error("Error saving city: {}", e.getMessage());
            throw new CitySqlException("Error saving city", e);
        }
    }
}
