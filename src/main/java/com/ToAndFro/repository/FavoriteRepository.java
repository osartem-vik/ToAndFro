package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.FavoriteAlreadyExistsException;
import com.ToAndFro.exceptions.FavoriteNotFoundException;
import com.ToAndFro.exceptions.FavoriteFailedAddException;
import com.ToAndFro.mapper.FavoriteMapper;
import com.ToAndFro.models.Favorite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoriteRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteRepository.class);
    private static final String ADD_FAVORITE_SQL = "INSERT IGNORE INTO favorite (user_id, listing_id) VALUES (?, ?)";
    private static final String REMOVE_FAVORITE_SQL = "DELETE FROM favorite WHERE user_id = ? AND listing_id = ?";
    private static final String FIND_FAVORITE_SQL = "SELECT * FROM favorite WHERE user_id = ? AND listing_id = ?";
    private static final String GET_FAVORITES_FOR_USER_SQL = "SELECT listing_id FROM favorite WHERE user_id = ?";
    private static final String GET_USERS_FOR_LISTING_SQL = "SELECT user_id FROM favorite WHERE listing_id = ?";
    private static final String COUNT_FAVORITES_FOR_LISTING_SQL = "SELECT COUNT(*) FROM favorite WHERE listing_id = ?";
    private final JDBCConnectionFactory connectionFactory;

    public FavoriteRepository() {
        this.connectionFactory = JDBCConnectionFactory.getInstance();
    }

    public Favorite saveFavorite(long userId, long listingId) {
        if (isFavorite(userId, listingId)) {
            throw new FavoriteAlreadyExistsException("Favorite already exists for user " + userId + " and listing " + listingId);
        }
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(ADD_FAVORITE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            FavoriteMapper.toPreparedStatement(stmt, new Favorite(userId, listingId), 1);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new FavoriteFailedAddException("Failed to add favorite for user " + userId + " and listing " + listingId);
            }
            LOGGER.debug("Added favorite for user {} and listing {}", userId, listingId);
            return new Favorite(userId, listingId);
        } catch (SQLException e) {
            LOGGER.error("Error adding favorite for user {} and listing {}", userId, listingId, e);
            throw new FavoriteFailedAddException("Failed to add favorite", e);
        }
    }

    public boolean removeFavorite(long userId, long listingId) {
        if (!isFavorite(userId, listingId)) {
            throw new FavoriteNotFoundException("Favorite not found for user " + userId + " and listing " + listingId);
        }
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(REMOVE_FAVORITE_SQL)) {
            FavoriteMapper.toPreparedStatement(stmt, new Favorite(userId, listingId), 1);
            int rowsAffected = stmt.executeUpdate();
            LOGGER.debug("Removed favorite for user {} and listing {}: rows affected = {}", userId, listingId, rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            LOGGER.error("Error removing favorite for user {} and listing {}", userId, listingId, e);
            throw new FavoriteFailedAddException("Failed to remove favorite", e);
        }
    }

    public boolean isFavorite(long userId, long listingId) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(FIND_FAVORITE_SQL)) {
            FavoriteMapper.toPreparedStatement(stmt, new Favorite(userId, listingId), 1);
            try (ResultSet rs = stmt.executeQuery()) {
                boolean exists = rs.next();
                LOGGER.debug("Is favorite for user {} and listing {}: {}", userId, listingId, exists);
                return exists;
            }
        } catch (SQLException e) {
            LOGGER.error("Error checking favorite for user {} and listing {}", userId, listingId, e);
            throw new FavoriteFailedAddException("Failed to check favorite", e);
        }
    }

    public List<Favorite> getFavoritesForUser(long userId) {
        List<Favorite> favorites = new ArrayList<>();
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(FIND_FAVORITE_SQL.replace("AND listing_id = ?", ""))) {  // Modify for all
            stmt.setLong(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    favorites.add(FavoriteMapper.mapToFavorite(rs));
                }
                LOGGER.debug("Retrieved {} favorite entries for user {}", favorites.size(), userId);
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving favorites for user {}", userId, e);
            throw new FavoriteFailedAddException("Failed to retrieve user favorites", e);
        }
        return favorites;
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
            throw new FavoriteFailedAddException("Failed to retrieve favorited users", e);
        }
        return userIds;
    }

    public int countFavoritesForListing(long listingId) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(COUNT_FAVORITES_FOR_LISTING_SQL)) {
            stmt.setLong(1, listingId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    LOGGER.debug("Favorite count for listing {}: {}", listingId, count);
                    return count;
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error counting favorites for listing {}", listingId, e);
            throw new FavoriteFailedAddException("Failed to count favorites", e);
        }
        return 0;
    }

    public Favorite getFavorite(long userId, long listingId) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(FIND_FAVORITE_SQL)) {
            FavoriteMapper.toPreparedStatement(stmt, new Favorite(userId, listingId), 1);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Favorite favorite = FavoriteMapper.mapToFavorite(rs);
                    LOGGER.debug("Retrieved favorite: {}", favorite);
                    return favorite;
                } else {
                    throw new FavoriteNotFoundException("Favorite not found for user " + userId + " and listing " + listingId);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error retrieving favorite for user {} and listing {}", userId, listingId, e);
            throw new FavoriteFailedAddException("Failed to retrieve favorite", e);
        }
    }
}

