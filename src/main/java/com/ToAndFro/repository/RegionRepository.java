package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.RegionSqlException;
import com.ToAndFro.models.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegionRepository {
    Logger LOGGER = LoggerFactory.getLogger(RegionRepository.class);
    private final String SAVE_REGION_QUERY = "INSERT INTO region (name) VALUES (?)";
    private final String UPDATE_REGION_QUERY = "UPDATE region SET name = ? WHERE id = ?";

    private final int noChangedRows = 0;

    public void setRegionParams(Region region, PreparedStatement statement) throws SQLException {
        statement.setString(1, region.getName());
    }

    public void save(Region region) {
        try(Connection connection = JDBCConnectionFactory.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_REGION_QUERY);
            setRegionParams(region, preparedStatement);

            int res = preparedStatement.executeUpdate();
            if(res == noChangedRows) {
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
        try(Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REGION_QUERY);
            setRegionParams(region, preparedStatement);
            preparedStatement.setLong(2, region.getId());

            int res = preparedStatement.executeUpdate();
            if(res == noChangedRows) {
                LOGGER.error("Failed updating region");
                throw new RegionSqlException("Failed updating region");
            }
            LOGGER.info("Region updated: {} rows affected", res);
        } catch (SQLException e) {
            LOGGER.error("Error updating region: {}", e.getMessage());
            throw new RegionSqlException("Error updating region", e);
        }
    }
}
