package edu.school21.chat.app;

import java.sql.*;
import java.util.Optional;
import java.util.Scanner;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;


public class Program {
    public static void main(String[] args) throws SQLException {  // исключения обработать ( ошибки )

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl(ds);

        Scanner scanner = new Scanner(System.in);
        Long messageId = 1L;

        System.out.println("Enter a message ID");
        if (scanner.hasNextLong()) {
            messageId = scanner.nextLong();
        } else {
            System.err.println("Wrong input");
            System.exit(-1);
        }
        scanner.close();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Cannot Load Driver");
            System.exit(-1);
        }

        Optional<Message> byId = messageRepository.findById(messageId);
        System.out.println(byId.get());
    }
}
