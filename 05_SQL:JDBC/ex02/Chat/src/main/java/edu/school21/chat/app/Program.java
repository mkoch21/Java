package edu.school21.chat.app;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;


public class Program {
    public static void main(String[] args) throws SQLException {  // исключения обработать ( ошибки )

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl(ds);

        User creator = new User(1L, "John", "123", new ArrayList<Chatroom>(), new ArrayList<Message>());

        Chatroom room = new Chatroom(1L, "general", creator, new ArrayList<Message>());

        Message message = new Message(null, creator, room, "Test Message", LocalDateTime.of(2020, 11, 11, 11, 11, 11));

        messageRepository.save(message);
        System.out.println(message.getMessageId());

        Optional<Message> byId = messageRepository.findById(message.getMessageId());
        System.out.println("byId.toString() = " +  byId.toString());
    }
}
