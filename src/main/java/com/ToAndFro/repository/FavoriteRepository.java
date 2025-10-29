package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.models.Favorite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteRepository.class);
    private static final String ADD_FAVORITE_SQL = "INSERT IGNORE INTO favorite (user_id, listing_id) VALUES (?, ?)";
    private static final String REMOVE_FAVORITE_SQL = "DELETE FROM favorite WHERE user_id = ? AND listing_id = ?";
    private static final String IS_FAVORITE_SQL = "SELECT COUNT(*) FROM favorite WHERE user_id = ? AND listing_id = ?";
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

    public boolean removeFavorite(long userId, long listingId) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(REMOVE_FAVORITE_SQL)) {
            stmt.setLong(1, userId);
            stmt.setLong(2, listingId);
            int rowsAffected = stmt.executeUpdate();
            LOGGER.debug("Removed favorite for user {} and listing {}: rows affected = {}", userId, listingId, rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            LOGGER.error("Error removing favorite for user {} and listing {}", userId, listingId, e);
            throw new RuntimeException("Failed to remove favorite", e);
        }
    }

    public boolean isFavorite(long userId, long listingId) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(IS_FAVORITE_SQL)) {
            stmt.setLong(1, userId);
            stmt.setLong(2, listingId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    boolean isFav = count > 0;
                    LOGGER.debug("Is favorite for user {} and listing {}: {}", userId, listingId, isFav);
                    return isFav;
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error checking favorite for user {} and listing {}", userId, listingId, e);
            throw new RuntimeException("Failed to check favorite", e);
        }
        return false;
    }
}

