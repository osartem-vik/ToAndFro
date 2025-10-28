package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.UserInsertException;
import com.ToAndFro.mapper.UserMapper;
import com.ToAndFro.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository {
    private final String USER_INSERT_QUERY =
            "INSERT INTO user (lastname, firstname, email, password_hash, phone) VALUES (?, ?, ?, ?, ?);";
    private final String USER_UPDATE_QUERY =
            "UPDATE user SET lastname = ?, firstname = ?, email = ?, password_hash = ?, phone = ? WHERE id = ?;";
    private final String USER_DELETE_QUERY =
            "DELETE FROM user WHERE id = ?;";
    private final String USER_FIND_BY_ID_QUERY =
            "SELECT id, lastname, firstname, email, password_hash, phone FROM user WHERE id = ?;";
    private final String USER_FIND_ALL_QUERY =
            "SELECT id, lastname, firstname, email, password_hash, phone FROM user;";

    private final UserMapper userMapper = new UserMapper();

    private void setUserParams(PreparedStatement ps, User user) throws SQLException {
        ps.setString(1, user.getLastName());
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getPhone());
    }


    public void save(User user) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(USER_INSERT_QUERY);
            setUserParams(ps, user);

            int result = ps.executeUpdate();
            if (result == 0) throw new UserInsertException("Failed to insert user");

        } catch (SQLException e) {
            throw new UserInsertException("Error saving user to DB", e);
        }
    }

    public void update(User user) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(USER_UPDATE_QUERY);
            setUserParams(ps, user);
            ps.setLong(6, user.getId());

            int result = ps.executeUpdate();
            if (result == 0) throw new UserInsertException("Failed to update user");

        } catch (SQLException e) {
            throw new UserInsertException("Error updating user in DB", e);
        }
    }

    public void delete(long userId) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(USER_DELETE_QUERY)) {

            ps.setLong(1, userId);

            int result = ps.executeUpdate();

            if (result == 0) {
                throw new UserInsertException("No user found with id: " + userId);
            }

        } catch (SQLException e) {
            throw new UserInsertException("Error deleting user with id: " + userId, e);
        }
    }

    public User findById(long userId) {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(USER_FIND_BY_ID_QUERY)) {

            ps.setLong(1, userId);

            ResultSet rs = ps.executeQuery();

            User user;

            if(rs.next()){
                user = userMapper.createUser(
                        rs.getLong("id"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getString("phone")
                );
            } else {
                throw new UserInsertException("No user found with id: " + userId);
            }

            return user;

        } catch (SQLException e) {
            throw new UserInsertException("Error finding user with id: " + userId, e);
        }
    }

    public List<User> findAll() {
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(USER_FIND_ALL_QUERY)) {

            ResultSet rs = ps.executeQuery();

            List<User> users = new java.util.ArrayList<>();

            while(rs.next()){
                User user = userMapper.createUser(
                        rs.getLong("id"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getString("phone")
                );
                users.add(user);
            }

            return users;

        } catch (SQLException e) {
            throw new UserInsertException("Error retrieving all users", e);
        }
    }


}
