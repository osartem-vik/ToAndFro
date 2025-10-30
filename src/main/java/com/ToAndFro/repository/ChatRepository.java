package com.ToAndFro.repository;

import com.ToAndFro.configs.JDBCConnectionFactory;
import com.ToAndFro.exceptions.ChatPersistenceFailed;
import com.ToAndFro.mapper.ChatMapper;
import com.ToAndFro.models.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatRepository.class);

    private static final String CHAT_INSERT_QUERY =
            "INSERT INTO chat (listing_id, buyer_id) VALUES (?, ?);";

    private static final String CHAT_UPDATE_QUERY =
            "UPDATE chat SET listing_id = ?, buyer_id = ? WHERE id = ?;";

    private static final String CHAT_DELETE_QUERY =
            "DELETE FROM chat WHERE id = ?;";

    private static final String CHAT_FIND_BY_ID_QUERY =
            "SELECT id, listing_id, buyer_id FROM chat WHERE id = ?;";

    private static final String CHAT_FIND_ALL_QUERY =
            "SELECT id, listing_id, buyer_id FROM chat;";

    private static final int NO_ROWS_AFFECTED = 0;

    public void save(Chat chat) {
        try (var connection = JDBCConnectionFactory.getInstance().getConnection();
             var ps = connection.prepareStatement(CHAT_INSERT_QUERY)) {
            setChatParams(ps, chat);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == NO_ROWS_AFFECTED) {
                LOGGER.error("Could not save chat with listing_id {}, buyer_id {}",
                        chat.getListingId(), chat.getBuyerId());
                throw new ChatPersistenceFailed("Failed to insert new chat");
            }
            LOGGER.info("Chat saved with listing_id {}, buyer_id {}",
                    chat.getListingId(), chat.getBuyerId());

        } catch (SQLException e) {
            LOGGER.error("Error saving chat with listing_id {}, buyer_id {}",
                    chat.getListingId(), chat.getBuyerId(), e);
            throw new ChatPersistenceFailed("Error saving chat", e);
        }
    }

    public void update(Chat chat) {
        try (var connection = JDBCConnectionFactory.getInstance().getConnection();
             var ps = connection.prepareStatement(CHAT_UPDATE_QUERY)) {

            setChatParams(ps, chat);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == NO_ROWS_AFFECTED) {
                throw new ChatPersistenceFailed("Chat not found for update with id " + chat.getId());
            }

            LOGGER.info("Chat updated with id {}", chat.getId());

        } catch (SQLException e) {
            LOGGER.error("Error updating chat", e);
            throw new ChatPersistenceFailed("Error updating chat", e);
        }
    }

    public void delete(Long id) {
        try (var connection = JDBCConnectionFactory.getInstance().getConnection();
             var ps = connection.prepareStatement(CHAT_DELETE_QUERY)) {
            int idIndex = 1;

            ps.setLong(idIndex, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == NO_ROWS_AFFECTED) {
                LOGGER.warn("No chat found with id {} to delete", id);
            }
            LOGGER.info("Chat deleted with id {}", id);


        } catch (SQLException e) {
            LOGGER.error("Error deleting chat with id {}", id, e);
            throw new ChatPersistenceFailed("Error deleting chat", e);
        }
    }

    public Chat findById(Long id) {
        try(var connection = JDBCConnectionFactory.getInstance().getConnection();
        var ps = connection.prepareStatement(CHAT_FIND_BY_ID_QUERY)) {
            int idIndex = 1;
            ps.setLong(idIndex, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    LOGGER.trace("Found chat with id {}", id);
                    return ChatMapper.map(rs);
                } else {
                    LOGGER.trace("No chat with id {}", id);
                    throw new ChatPersistenceFailed("No chat with id " + id);
                }

            }

        } catch (SQLException e) {
            LOGGER.error("Error finding chat with id {}", id, e);
            throw new ChatPersistenceFailed("Error finding chat", e);
        }
    }

    public List<Chat> findAll() {
        try(var connection = JDBCConnectionFactory.getInstance().getConnection();
        var ps = connection.prepareStatement(CHAT_FIND_ALL_QUERY);
        ResultSet rs = ps.executeQuery()) {
            List<Chat> chats = new ArrayList<>();
            while (rs.next()) {
                chats.add(ChatMapper.map(rs));
            }

            LOGGER.info("Found {} chats", chats.size());
            return chats;

        } catch (SQLException e) {
            LOGGER.error("Error finding all chats", e);
            throw new ChatPersistenceFailed("Error finding all chats", e);
        }
    }

    private void setChatParams(PreparedStatement ps, Chat chat) throws SQLException {
        ps.setLong(1, chat.getListingId());
        ps.setLong(2, chat.getBuyerId());
    }

}
