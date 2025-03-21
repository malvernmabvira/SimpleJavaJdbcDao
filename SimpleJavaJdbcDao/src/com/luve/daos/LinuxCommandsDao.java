package com.luve.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luve.models.LinuxCommands;

public class LinuxCommandsDao {
	
	private static String url = DatabaseConnection.getUrl();
    private static String userName = DatabaseConnection.getUserName();
    private static String password = DatabaseConnection.getPassword();
	
	public void insertCommand(LinuxCommands linuxCommands) {
        try (Connection conn = DatabaseConnection.getConnection(url, userName, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO commands (command, description, example) VALUES (?, ?, ?)")) {
            stmt.setString(1, linuxCommands.getCommand());
            stmt.setString(2, linuxCommands.getDescription());
            stmt.setString(3, linuxCommands.getExample());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LinuxCommands> getAllCommands() {
        List<LinuxCommands> linuxCommands = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(url, userName, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM commands")) {
            while (rs.next()) {
            	linuxCommands.add(new LinuxCommands(rs.getInt("id"), rs.getString("command"), rs.getString("description"), rs.getString("example")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linuxCommands;
    }

}
