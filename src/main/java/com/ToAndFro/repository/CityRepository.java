package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.CityOperationException;
import com.ToAndFro.mapper.CityMapper;
import com.ToAndFro.models.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityRepository.class);
    private static final String SAVE_CITY_QUERY = "INSERT INTO city(name, region_id) VALUES (?, ?)";
    private static final String UPDATE_CITY_QUERY = "UPDATE city SET name = ?, region_id = ? WHERE id = ?";
    private static final String DELETE_CITY_QUERY = "DELETE FROM city WHERE id = ?";
    private static final String FIND_CITY_BY_ID_QUERY = "SELECT * FROM city WHERE id = ?";
    private static final String FIND_ALL_CITY_QUERY = "SELECT * FROM city";

    private final CityMapper cityMapper = new CityMapper();
    private final int noChangedRows = 0;

    private void setCityParams(City city, PreparedStatement statement) throws SQLException {
        int nameColumn = 1;
        int regionIdColumn = 2;

        statement.setString(nameColumn, city.getName());
        statement.setLong(regionIdColumn, city.getRegionId());
    }

    public void save(City city) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CITY_QUERY)) {
            setCityParams(city, preparedStatement);

            int result = preparedStatement.executeUpdate();
            if (result == noChangedRows) {
                LOGGER.error("Failed saving city");
                throw new CityOperationException("Failed saving city");
            }
            LOGGER.info("City saved: {} rows affected", result);
        } catch (SQLException e) {
            LOGGER.error("Error saving city: {}", e.getMessage());
            throw new CityOperationException("Error saving city", e);
        }
    }

    public void update(City city) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITY_QUERY)) {
            setCityParams(city, preparedStatement);

            int idColumn = 3;
            preparedStatement.setLong(idColumn, city.getId());

            int result = preparedStatement.executeUpdate();
            if (result == noChangedRows) {
                LOGGER.error("Failed updating city");
                throw new CityOperationException("Failed updating city");
            }
            LOGGER.info("City updated: {} rows affected", result);
        } catch (SQLException e) {
            LOGGER.error("Error updating city: {}", e.getMessage());
            throw new CityOperationException("Error updating city", e);
        }
    }

    public void delete(Long id) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITY_QUERY)) {

            int idColumn = 1;
            preparedStatement.setLong(idColumn, id);

            int result = preparedStatement.executeUpdate();
            if (result == noChangedRows) {
                LOGGER.error("Failed deleting city");
                throw new CityOperationException("Failed deleting city");
            }
            LOGGER.info("City deleted: {} rows affected", result);
        } catch (SQLException e) {
            LOGGER.error("Error deleting city: {}", e.getMessage());
            throw new CityOperationException("Error deleting city", e);
        }
    }

    public City findById(Long id) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_CITY_BY_ID_QUERY)) {

            int idColumn = 1;
            preparedStatement.setLong(idColumn, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    LOGGER.info("City found");
                    return cityMapper.mapToCity(resultSet);
                } else {
                    LOGGER.error("No city found with id: {}", id);
                    throw new CityOperationException("No city found with id: " + id);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding city with id {}: {}", id, e.getMessage());
            throw new CityOperationException("Error finding city with id: " + id, e);
        }
    }

    public List<City> findAll() {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CITY_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                cities.add(cityMapper.mapToCity(resultSet));
            }
            LOGGER.info("Got {} cities from DB", cities.size());
            return cities;
        } catch (SQLException e) {
            LOGGER.error("Error getting all cities: {}", e.getMessage());
            throw new CityOperationException("Error getting all cities", e);
        }
    }
}
