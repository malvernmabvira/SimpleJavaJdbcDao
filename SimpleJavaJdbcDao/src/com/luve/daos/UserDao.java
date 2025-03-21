package com.luve.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.luve.models.User;

public class UserDao {
    
    private static String url = DatabaseConnection.getUrl();
    private static String userName = DatabaseConnection.getUserName();
    private static String password = DatabaseConnection.getPassword();

    public void insertUser(User user) {
        try (Connection conn = DatabaseConnection.getConnection(url, userName, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(url, userName, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

