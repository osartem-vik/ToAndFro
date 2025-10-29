package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.models.Favorite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FavoriteRepository {
    private final static Logger LOGGER = LoggerFactory.getLogger(FavoriteRepository.class);
    private static final String ADD_FAVORITE_SQL = "INSERT IGNORE INTO favorite (user_id, listing_id) VALUES (?, ?)";
    private final JDBCConnectionFactory connectionFactory;
    public FavoriteRepository() {
        this.connectionFactory = JDBCConnectionFactory.getInstance();
    }
    public boolean addFavorite(long userId, long listingId) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(ADD_FAVORITE_SQL)) {
            stmt.setLong(1, userId);
            stmt.setLong(2, listingId);
            int rowsAffected = stmt.executeUpdate();
            LOGGER.debug("Added favorite for user {} and listing {}: rows affected = {}", userId, listingId, rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            LOGGER.error("Error adding favorite for user {} and listing {}", userId, listingId, e);
            throw new RuntimeException("Failed to add favorite", e);
        }
    }
}
