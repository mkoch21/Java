package edu.school21.chat.repositories;

import edu.school21.chat.models.*;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessageRepository {

    private final DataSource ds;

    public MessagesRepositoryJdbcImpl (DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        String url = "jdbc:postgresql://localhost:5432/postgres";

        Connection conn = DriverManager.getConnection(url);

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(" SELECT * FROM chat.message WHERE id = " + id + " ;");

        resultSet.next();

        User user = new User(1L, "mkoch", "123", null, null);

        Chatroom chatroom = new Chatroom(1L, "chatroom", null, null);

        Message message = null;
        try {
            message = new Message(resultSet.getLong(1), user, chatroom, resultSet.getString("message"), resultSet.getObject(5, LocalDateTime.class));
        } catch (SQLException e) {
            System.err.println("Message Doesn't exist");
            System.exit(-1);
        }

        optionalMessage = Optional.of(message);
        statement.close();
        conn.close();

        return optionalMessage;
    }
}
