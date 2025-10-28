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

    public void setRegionParams(Region region, PreparedStatement statement) throws SQLException {
        statement.setString(1, region.getName());
    }

    public void save(Region region) {
        try(Connection connection = JDBCConnectionFactory.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_REGION_QUERY);
            setRegionParams(region, preparedStatement);
            int res = preparedStatement.executeUpdate();
            if(res == 0) {
                LOGGER.error("Failed saving region");
                throw new RegionSqlException("Failed saving region");
            }
        } catch (SQLException e) {
            LOGGER.error("Error saving region: {}", e.getMessage());
            throw new RegionSqlException("Error saving region", e);
        }
    }

}
