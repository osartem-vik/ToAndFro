package com.ToAndFro.mapper;

import com.ToAndFro.models.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatMapper.class);

    public static Chat map(ResultSet rs) throws SQLException {
        try {
            Chat chat = new Chat(
                    rs.getLong("id"),
                    rs.getLong("listing_id"),
                    rs.getLong("buyer_id")
            );
            LOGGER.info("Map chat with id {}", chat.getId());
            return chat;
        } catch (SQLException | IllegalArgumentException e){
            LOGGER.error("Error while mapping chat object", e);
            throw new RuntimeException(e);
        }
    }
}
