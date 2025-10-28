package com.ToAndFro.mapper;

import com.ToAndFro.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public User createUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("lastname"),
                rs.getString("firstname"),
                rs.getString("email"),
                rs.getString("password_hash"),
                rs.getString("phone"));
    }
}
