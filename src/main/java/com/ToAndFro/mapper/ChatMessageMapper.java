package com.ToAndFro.mapper;

import com.ToAndFro.models.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatMessageMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatMessageMapper.class);

    public static ChatMessage map(ResultSet rs) throws SQLException {
        try {
            ChatMessage chatMessage = new ChatMessage(
                    rs.getLong("id"),
                    rs.getLong("sender_id"),
                    rs.getLong("chat_id"),
                    rs.getString("text"),
                    rs.getTimestamp("timestamp").toLocalDateTime()
            );
            LOGGER.info("Map chatMessage with id {}", chatMessage.getId());
            return chatMessage;
        } catch (SQLException | IllegalArgumentException e){
            LOGGER.error("Error while mapping chatMessage", e);
            throw new RuntimeException(e);
        }
    }

}
