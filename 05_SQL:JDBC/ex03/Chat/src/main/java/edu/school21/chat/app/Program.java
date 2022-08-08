package edu.school21.chat.app;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;

public class Program {
    public static void main(String[] args) throws SQLException {  // исключения обработать ( ошибки )

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl(ds);

        Optional<Message> messageOptional = messageRepository.findById(3L);

        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();

            message.setText("Test message!");
            message.setDateTime(LocalDateTime.now());
            messageRepository.update(message);

            Optional<Message> byId = messageRepository.findById(message.getMessageId());
            System.out.println(byId.get());
        }
    }
}
