package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.ListingSqlException;
import com.ToAndFro.mapper.ListingMapper;
import com.ToAndFro.models.Listing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListingRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListingRepository.class);

    private final String INSERT_QUERY = "INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE listing SET category = ?, city_id = ?, title = ?, description = ?, price = ?, status = ? WHERE id = ?";
    private final String DELETE_QUERY = "DELETE FROM listing WHERE id = ?";
    private final String FIND_BY_ID_QUERY = "SELECT * FROM listing WHERE id = ?";
    private final String FIND_ALL_QUERY = "SELECT * FROM listing";

    public void save(Listing listing) {
        LOGGER.info("Saving listing with title: {}", listing.getTitle());
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {

            ps.setLong(1, listing.getUserId());
            ps.setString(2, listing.getCategory().name());
            ps.setLong(3, listing.getCityId());
            ps.setString(4, listing.getTitle());
            ps.setString(5, listing.getDescription());
            ps.setBigDecimal(6, listing.getPrice());
            ps.setTimestamp(7, Timestamp.valueOf(listing.getCreatedAt()));
            ps.setString(8, listing.getStatus().name());

            int result = ps.executeUpdate();
            if (result == 0) {
                LOGGER.warn("Insert failed for listing with title: {}", listing.getTitle());
                throw new ListingSqlException("Failed to insert listing");
            }

            LOGGER.info("Listing saved successfully with title: {}", listing.getTitle());

        } catch (SQLException e) {
            LOGGER.error("Error saving listing with title: {}", listing.getTitle(), e);
            throw new ListingSqlException("Error saving listing", e);
        }
    }

    public void update(Listing listing) {
        LOGGER.info("Updating listing with id: {}", listing.getId());
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {

            ps.setString(1, listing.getCategory().name());
            ps.setLong(2, listing.getCityId());
            ps.setString(3, listing.getTitle());
            ps.setString(4, listing.getDescription());
            ps.setBigDecimal(5, listing.getPrice());
            ps.setString(6, listing.getStatus().name());
            ps.setLong(7, listing.getId());

            int result = ps.executeUpdate();
            if (result == 0) {
                LOGGER.warn("No listing found to update with id: {}", listing.getId());
                throw new ListingSqlException("No listing found to update with id: " + listing.getId());
            }

            LOGGER.info("Listing updated successfully with id: {}", listing.getId());

        } catch (SQLException e) {
            LOGGER.error("Error updating listing with id: {}", listing.getId(), e);
            throw new ListingSqlException("Error updating listing", e);
        }
    }

    public void delete(long id) {
        LOGGER.info("Deleting listing with id: {}", id);
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {

            ps.setLong(1, id);
            int result = ps.executeUpdate();
            if (result == 0) {
                LOGGER.warn("No listing found to delete with id: {}", id);
                throw new ListingSqlException("No listing found to delete with id: " + id);
            }

            LOGGER.info("Listing deleted successfully with id: {}", id);

        } catch (SQLException e) {
            LOGGER.error("Error deleting listing with id: {}", id, e);
            throw new ListingSqlException("Error deleting listing", e);
        }
    }

    public Listing findById(long id) {
        LOGGER.info("Finding listing by id: {}", id);
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_QUERY)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                LOGGER.info("Listing found with id: {}", id);
                return ListingMapper.map(rs);
            } else {
                LOGGER.warn("Listing not found with id: {}", id);
                throw new ListingSqlException("Listing not found with id: " + id);
            }

        } catch (SQLException e) {
            LOGGER.error("Error finding listing with id: {}", id, e);
            throw new ListingSqlException("Error finding listing", e);
        }
    }

    public List<Listing> findAll() {
        LOGGER.info("Retrieving all listings");
        try (Connection connection = JDBCConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_ALL_QUERY)) {

            ResultSet rs = ps.executeQuery();
            List<Listing> listings = new ArrayList<>();

            while (rs.next()) {
                listings.add(ListingMapper.map(rs));
            }

            LOGGER.info("Retrieved {} listings from DB", listings.size());
            return listings;

        } catch (SQLException e) {
            LOGGER.error("Error retrieving all listings", e);
            throw new ListingSqlException("Error retrieving listings", e);
        }
    }
}
