package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

    private Long userId;

    private String login;

    private String password;

    private List<Chatroom> chatrooms;

    private List<Message> messages;

    public User(Long userId, String login, String password, List<Chatroom> chatrooms, List<Message> messages) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.chatrooms = chatrooms;
        this.messages = messages;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getChatrooms() {
        return this.chatrooms;
    }

    public void setChatrooms(List<Chatroom> chatrooms) {
        this.chatrooms = chatrooms;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(chatrooms, user.chatrooms) && Objects.equals(messages, user.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, chatrooms, messages);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
