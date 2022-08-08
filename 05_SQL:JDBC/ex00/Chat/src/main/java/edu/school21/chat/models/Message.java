package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Long messageId;

    private User author;

    private Chatroom room;

    private String text;

    private LocalDateTime dateTime;

    public Message (Long messageId, User author, Chatroom room, String text, LocalDateTime date) {
        this.messageId = messageId;
        this.author = author;
        this.room = room;
        this.text = text;
        this.dateTime = LocalDateTime.now();
    }

    public Long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return this.room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getdate() {
        return this.dateTime;
    }

    public void setdate(LocalDateTime date) {
        this.dateTime = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId) && Objects.equals(author, message.author) && Objects.equals(room, message.room) && Objects.equals(text, message.text) && Objects.equals(dateTime, message.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, author, room, text, dateTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", author='" + author + '\'' +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
