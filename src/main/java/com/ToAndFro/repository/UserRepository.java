package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.UserSqlException;
import com.ToAndFro.mapper.UserMapper;
import com.ToAndFro.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

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
        LOGGER.info("Method save called for user with email: {}", user.getEmail());
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(USER_INSERT_QUERY)) {
            setUserParams(ps, user);

            int result = ps.executeUpdate();
            if (result == 0){
                LOGGER.warn("Insert failed for user with email: {}", user.getEmail());
                throw new UserSqlException("Failed to insert user");
            }

            LOGGER.info("User saved successfully to DB with email: {}", user.getEmail());

        } catch (SQLException e) {
            LOGGER.error("Error saving user with email {} to DB", user.getEmail());
            throw new UserSqlException("Error saving user to DB", e);
        }
    }

    public void update(User user) {
        LOGGER.info("Method update called for user with id: {}", user.getId());
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(USER_UPDATE_QUERY)) {
            setUserParams(ps, user);

            int idColumnPosition = 6;
            ps.setLong(idColumnPosition, user.getId());

            int result = ps.executeUpdate();
            if (result == 0){
                LOGGER.warn("No user found to update with id: {}", user.getId());
                throw new UserSqlException("Failed to update user");
            }

            LOGGER.info("User updated successfully with id: {}", user.getId());

        } catch (SQLException e) {
            LOGGER.error("Error updating user in DB with id: {}", user.getId());
            throw new UserSqlException("Error updating user in DB", e);
        }
    }

    public void delete(long userId) {
        LOGGER.info("Method delete called for user with id: {}", userId);
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(USER_DELETE_QUERY)) {

            int idColumnPosition = 1;
            ps.setLong(idColumnPosition, userId);

            int result = ps.executeUpdate();

            if (result == 0) {
                LOGGER.warn("No user found with id: {}", userId);
                throw new UserSqlException("No user found with id: " + userId);
            }

            LOGGER.info("User deleted successfully with id: {}", userId);

        } catch (SQLException e) {
            LOGGER.error("Error deleting user with id: {}", userId);
            throw new UserSqlException("Error deleting user with id: " + userId, e);
        }
    }

    public User findById(long userId) {
        LOGGER.info("Method findById called for user with id: {}", userId);
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(USER_FIND_BY_ID_QUERY)) {

            int idColumnPosition = 1;
            ps.setLong(idColumnPosition, userId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                LOGGER.info("User found with id: {}", userId);
                return userMapper.mapToUser(rs);
            } else {
                LOGGER.warn("User not found with id: {}", userId);
                throw new UserSqlException("No user found with id: " + userId);
            }

        } catch (SQLException e) {
            LOGGER.error("Error finding user with id: {}", userId);
            throw new UserSqlException("Error finding user with id: " + userId, e);
        }
    }

    public List<User> findAll() {
        LOGGER.info("Method findAll called");
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(USER_FIND_ALL_QUERY)) {

            ResultSet rs = ps.executeQuery();

            List<User> users = new ArrayList<>();

            while(rs.next()){
                User user = userMapper.mapToUser(rs);
                users.add(user);
            }

            LOGGER.info("Got {} users from DB", users.size());

            return users;

        } catch (SQLException e) {
            LOGGER.error("Error retrieving all users");
            throw new UserSqlException("Error retrieving all users", e);
        }
    }
}
