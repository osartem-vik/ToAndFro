package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.RegionSqlException;
import com.ToAndFro.mapper.RegionMapper;
import com.ToAndFro.models.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegionRepository.class);
    private final String SAVE_REGION_QUERY = "INSERT INTO region (name) VALUES (?)";
    private final String UPDATE_REGION_QUERY = "UPDATE region SET name = ? WHERE id = ?";
    private final String DELETE_REGION_QUERY = "DELETE FROM region WHERE id = ?";
    private final String FIND_REGION_BY_ID_QUERY = "SELECT * FROM region WHERE id = ?";
    private final String FIND_ALL_REGION_QUERY = "SELECT * FROM region";

    private RegionMapper regionMapper = new RegionMapper();
    private final int noChangedRows = 0;

    private void setRegionParams(Region region, PreparedStatement statement) throws SQLException {
        int nameIndex = 1;
        statement.setString(nameIndex, region.getName());
    }

    public void save(Region region) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_REGION_QUERY)) {
            setRegionParams(region, preparedStatement);

            int res = preparedStatement.executeUpdate();
            if (res == noChangedRows) {
                LOGGER.error("Failed saving region");
                throw new RegionSqlException("Failed saving region");
            }
            LOGGER.info("Region saved: {} rows affected", res);
        } catch (SQLException e) {
            LOGGER.error("Error saving region: {}", e.getMessage());
            throw new RegionSqlException("Error saving region", e);
        }
    }

    public void update(Region region) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REGION_QUERY)) {
            setRegionParams(region, preparedStatement);

            int idIndex = 2;
            preparedStatement.setLong(idIndex, region.getId());

            int res = preparedStatement.executeUpdate();
            if (res == noChangedRows) {
                LOGGER.error("Failed updating region");
                throw new RegionSqlException("Failed updating region");
            }
            LOGGER.info("Region updated: {} rows affected", res);
        } catch (SQLException e) {
            LOGGER.error("Error updating region: {}", e.getMessage());
            throw new RegionSqlException("Error updating region", e);
        }
    }

    public void delete(Long id) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REGION_QUERY)) {

            int idIndex = 1;
            preparedStatement.setLong(idIndex, id);

            int res = preparedStatement.executeUpdate();
            if (res == noChangedRows) {
                LOGGER.error("Failed deleting region");
                throw new RegionSqlException("Failed deleting region");
            }
            LOGGER.info("Region deleted: {} rows affected", res);
        } catch (SQLException e) {
            LOGGER.error("Error deleting region: {}", e.getMessage());
            throw new RegionSqlException("Error deleting region", e);
        }
    }

    public Region findById(Long id) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_REGION_BY_ID_QUERY)) {

            int idIndex = 1;
            preparedStatement.setLong(idIndex, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Region region;
            if (resultSet.next()) {
                region = regionMapper.mapToRegion(resultSet);
            } else {
                LOGGER.error("No region found with id {}", id);
                throw new RegionSqlException("No region found with id" + id);
            }
            LOGGER.info("Region found");
            return region;
        } catch (SQLException e) {
            LOGGER.error("Error finding region with id {}: {}", id, e.getMessage());
            throw new RegionSqlException("Error finding region with id " + id, e);
        }
    }

    public List<Region> findAll() {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_REGION_QUERY)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Region> regions = new ArrayList<>();
            while (resultSet.next()) {
                regions.add(regionMapper.mapToRegion(resultSet));
            }
            LOGGER.info("Got {} regions from DB", regions.size());
            return regions;
        } catch (SQLException e) {
            LOGGER.error("Error getting all regions: {}", e.getMessage());
            throw new RegionSqlException("Error getting all regions", e);
        }
    }
}
