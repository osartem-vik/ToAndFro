package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.CitySqlException;
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
    private final String SAVE_CITY_QUERY = "INSERT INTO city(name, region_id) VALUES (?, ?)";
    private final String UPDATE_CITY_QUERY = "UPDATE city SET name = ?, region_id = ? WHERE id = ?";
    private final String DELETE_CITY_QUERY = "DELETE FROM city WHERE id = ?";
    private final String FIND_CITY_BY_ID_QUERY = "SELECT * FROM city WHERE id = ?";
    private final String FIND_ALL_CITY_QUERY = "SELECT * FROM city";

    private CityMapper cityMapper = new CityMapper();
    private final int noChangedRows = 0;

    private void setCityParams(City city, PreparedStatement statement) throws SQLException {
        int nameIndex = 1;
        int regionIdIndex = 2;

        statement.setString(nameIndex, city.getName());
        statement.setLong(regionIdIndex, city.getRegionId());
    }

    public void save(City city) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
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

    public void update(City city) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITY_QUERY);
            setCityParams(city, preparedStatement);

            int idIndex = 3;
            preparedStatement.setLong(idIndex, city.getId());

            int res = preparedStatement.executeUpdate();
            if (res == noChangedRows) {
                LOGGER.error("Failed updating city");
                throw new CitySqlException("Failed updating city");
            }
            LOGGER.info("City updated: {} rows affected", res);
        } catch (SQLException e) {
            LOGGER.error("Error updating city: {}", e.getMessage());
            throw new CitySqlException("Error updating city", e);
        }
    }

    public void delete(Long id) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITY_QUERY);

            int idIndex = 1;
            preparedStatement.setLong(idIndex, id);

            int res = preparedStatement.executeUpdate();
            if (res == noChangedRows) {
                LOGGER.error("Failed deleting city");
                throw new CitySqlException("Failed deleting city");
            }
            LOGGER.info("City deleted: {} rows affected", res);
        } catch (SQLException e) {
            LOGGER.error("Error deleting city: {}", e.getMessage());
            throw new CitySqlException("Error deleting city", e);
        }
    }

    public City findById(Long id) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CITY_BY_ID_QUERY);

            int idIndex = 1;
            preparedStatement.setLong(idIndex, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            City city;
            if (resultSet.next()) {
                city = cityMapper.createCity(resultSet);
            } else {
                LOGGER.error("No city found with id: {}", id);
                throw new CitySqlException("No region found with id: " + id);
            }
            LOGGER.info("City found");
            return city;
        } catch (SQLException e) {
            LOGGER.error("Error finding city with id {}: {}", id, e.getMessage());
            throw new CitySqlException("Error finding city with id: " + id, e);
        }
    }

    public List<City> findAll() {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CITY_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                cities.add(cityMapper.createCity(resultSet));
            }
            LOGGER.info("Got {} cities from DB", cities.size());
            return cities;
        } catch (SQLException e) {
            LOGGER.error("Error getting all cities: {}", e.getMessage());
            throw new CitySqlException("Error getting all cities", e);
        }
    }
}
