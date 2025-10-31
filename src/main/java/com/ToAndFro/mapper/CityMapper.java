package com.ToAndFro.mapper;

import com.ToAndFro.models.City;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper {
    public City mapToCity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getLong("region_id")
        );
    }
}
