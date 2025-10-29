package com.ToAndFro.mapper;

import com.ToAndFro.models.Category;
import com.ToAndFro.models.Listing;
import com.ToAndFro.models.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListingMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListingMapper.class);

    public static Listing map(ResultSet rs) throws SQLException {
        try {
            Listing listing = new Listing(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    Category.valueOf(rs.getString("category")),
                    rs.getLong("city_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getTimestamp("created_at").toLocalDateTime(),
                    Status.valueOf(rs.getString("status"))
            );

            LOGGER.debug("Mapped listing with id: {}", listing.getId());
            return listing;

        } catch (SQLException | IllegalArgumentException e) {
            LOGGER.error("Error mapping listing from ResultSet", e);
            throw e;
        }
    }
}
