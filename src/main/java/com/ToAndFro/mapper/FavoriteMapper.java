package com.ToAndFro.mapper;

import com.ToAndFro.models.Favorite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteMapper.class);

    public static Favorite mapToFavorite(ResultSet rs) throws SQLException {
        long userId = rs.getLong("user_id");
        long listingId = rs.getLong("listing_id");
        Favorite favorite = new Favorite(userId, listingId);
        LOGGER.debug("Mapped Favorite from ResultSet: userId={}, listingId={}", userId, listingId);
        return favorite;
    }

    public static void toPreparedStatement(java.sql.PreparedStatement stmt, Favorite favorite, int index) throws SQLException {
        stmt.setLong(index++, favorite.getUserId());
        stmt.setLong(index, favorite.getListingId());
        LOGGER.debug("Mapped Favorite to PreparedStatement: userId={}, listingId={}", favorite.getUserId(), favorite.getListingId());
    }
}
