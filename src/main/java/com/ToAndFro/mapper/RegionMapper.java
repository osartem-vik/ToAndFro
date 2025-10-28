package com.ToAndFro.mapper;

import com.ToAndFro.models.Region;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionMapper {
    public Region createRegion(ResultSet resultSet) throws SQLException {
        return new Region(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }
}
