package com.ToAndFro.mapper;

import com.ToAndFro.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);

    public User createUser(ResultSet rs) throws SQLException {
        LOGGER.info("Mapping ResultSet to User object");
        return new User(
                rs.getLong("id"),
                rs.getString("lastname"),
                rs.getString("firstname"),
                rs.getString("email"),
                rs.getString("password_hash"),
                rs.getString("phone"));
    }
}
