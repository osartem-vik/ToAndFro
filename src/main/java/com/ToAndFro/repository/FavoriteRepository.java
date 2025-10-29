package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.models.Favorite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteRepository.class);
    private static final String ADD_FAVORITE_SQL = "INSERT IGNORE INTO favorite (user_id, listing_id) VALUES (?, ?)";
    private static final String REMOVE_FAVORITE_SQL = "DELETE FROM favorite WHERE user_id = ? AND listing_id = ?";
    private static final String IS_FAVORITE_SQL = "SELECT COUNT(*) FROM favorite WHERE user_id = ? AND listing_id = ?";
    private static final String GET_FAVORITES_FOR_USER_SQL = "SELECT listing_id FROM favorite WHERE user_id = ?";
    private static final String GET_USERS_FOR_LISTING_SQL = "SELECT user_id FROM favorite WHERE listing_id = ?";
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
    public List<Long> getFavoriteListingsForUser(long userId) {
        List<Long> listingIds = new ArrayList<>();
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_FAVORITES_FOR_USER_SQL)) {
            stmt.setLong(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    listingIds.add(rs.getLong("listing_id"));
                }
                LOGGER.debug("Retrieved {} favorite listings for user {}", listingIds.size(), userId);
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving favorites for user {}", userId, e);
            throw new RuntimeException("Failed to retrieve user favorites", e);
        }
        return listingIds;
    }
    public List<Long> getUsersWhoFavoritedListing(long listingId) {
        List<Long> userIds = new ArrayList<>();
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_USERS_FOR_LISTING_SQL)) {
            stmt.setLong(1, listingId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    userIds.add(rs.getLong("user_id"));
                }
                LOGGER.debug("Retrieved {} users who favorited listing {}", userIds.size(), listingId);
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving users for favorited listing {}", listingId, e);
            throw new RuntimeException("Failed to retrieve favorited users", e);
        }
        return userIds;
    }
}

