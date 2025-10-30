package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.ChatMessagePersistenceFailed;
import com.ToAndFro.mapper.ChatMessageMapper;
import com.ToAndFro.models.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChatMessageRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatMessageRepository.class);

    private static final String CHAT_MESSAGE_INSERT_QUERY =
            "INSERT INTO chat_messages (sender_id, chat_id, text, timestamp) VALUES (?, ?, ?, ?);";

    private static final String CHAT_MESSAGE_UPDATE_QUERY =
            "UPDATE chat_messages SET sender_id = ?, chat_id = ?, text = ?, timestamp = ? WHERE id = ?;";

    private static final String CHAT_MESSAGE_DELETE_QUERY =
            "DELETE FROM chat_messages WHERE id = ?;";

    private static final String CHAT_MESSAGE_FIND_BY_ID_QUERY =
            "SELECT id, sender_id, chat_id, text, timestamp FROM chat_messages WHERE id = ?;";

    private static final String CHAT_MESSAGE_FIND_ALL_QUERY =
            "SELECT id, sender_id, chat_id, text, timestamp FROM chat_messages WHERE chat_id = ?;";

    private static final int NO_ROWS_AFFECTED = 0;

    public void save(ChatMessage chatMessage) {
        try (var connection = JDBCConnectionFactory.getInstance().getConnection();
        var ps = connection.prepareStatement(CHAT_MESSAGE_INSERT_QUERY)){
        setChatMessageParams(ps, chatMessage);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == NO_ROWS_AFFECTED) {
                LOGGER.error("Could not save message with id {}, no rows affected", chatMessage.getId());
                throw new ChatMessagePersistenceFailed("Failed to save chat message");
            }
            LOGGER.info("Message saved with id {}", chatMessage.getId());
        } catch (SQLException e){
            LOGGER.error("Error saving chat message with id {}", chatMessage.getId(), e);
            throw new ChatMessagePersistenceFailed("Error saving chat message", e);
        }
    }

    public void update(ChatMessage chatMessage) {
        try (var connection = JDBCConnectionFactory.getInstance().getConnection();
             var ps = connection.prepareStatement(CHAT_MESSAGE_UPDATE_QUERY)) {

            setChatMessageParams(ps, chatMessage);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == NO_ROWS_AFFECTED) {
                throw new ChatMessagePersistenceFailed("Chat message not found for update with id " + chatMessage.getId());
            }

            LOGGER.info("Chat message updated with id {}", chatMessage.getId());

        } catch (SQLException e) {
            LOGGER.error("Error updating chat message", e);
            throw new ChatMessagePersistenceFailed("Error updating chat message", e);
        }
    }

    public void delete(Long id) {
        try (var connection = JDBCConnectionFactory.getInstance().getConnection();
             var ps = connection.prepareStatement(CHAT_MESSAGE_DELETE_QUERY)) {
            int idIndex = 1;

            ps.setLong(idIndex, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == NO_ROWS_AFFECTED) {
                LOGGER.warn("No chat message found with id {} to delete", id);
            }
            LOGGER.info("Chat message deleted with id {}", id);


        } catch (SQLException e) {
            LOGGER.error("Error deleting chat message with id {}", id, e);
            throw new ChatMessagePersistenceFailed("Error deleting chat message", e);
        }
    }

    public ChatMessage findById(Long id) {
        try(var connection = JDBCConnectionFactory.getInstance().getConnection();
            var ps = connection.prepareStatement(CHAT_MESSAGE_FIND_BY_ID_QUERY)) {
            int idIndex = 1;
            ps.setLong(idIndex, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    LOGGER.trace("Found chat message with id {}", id);
                    return ChatMessageMapper.map(rs);
                } else {
                    LOGGER.trace("No chat message with id {}", id);
                    throw new ChatMessagePersistenceFailed("No chat message with id " + id);
                }

            }

        } catch (SQLException e) {
            LOGGER.error("Error finding chat message with id {}", id, e);
            throw new ChatMessagePersistenceFailed("Error finding chat message", e);
        }
    }

    public List<ChatMessage> findAllByChatId(Long chatId) {
        try(var connection = JDBCConnectionFactory.getInstance().getConnection();
            var ps = connection.prepareStatement(CHAT_MESSAGE_FIND_ALL_QUERY)) {

            ps.setLong(1, chatId);

            try (ResultSet rs = ps.executeQuery()) {
                List<ChatMessage> chatMessages = new ArrayList<>();
                while (rs.next()) {
                    chatMessages.add(ChatMessageMapper.map(rs));
                }

                LOGGER.info("Found {} chat messages", chatMessages.size());
                return chatMessages;
            }

        } catch (SQLException e) {
            LOGGER.error("Error finding all chat message", e);
            throw new ChatMessagePersistenceFailed("Error finding all chat messages", e);
        }
    }

    private void setChatMessageParams(PreparedStatement ps, ChatMessage chatMessage) throws SQLException {
        ps.setLong(1, chatMessage.getSenderId());
        ps.setLong(2, chatMessage.getChatId());
        ps.setString(3, chatMessage.getText());
        ps.setTimestamp(4, Timestamp.valueOf(chatMessage.getTimestamp()));
    }
}
