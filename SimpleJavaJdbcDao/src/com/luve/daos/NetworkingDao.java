package com.luve.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luve.models.Networking;


public class NetworkingDao {
	
	private static String url = DatabaseConnection.getUrl();
    private static String userName = DatabaseConnection.getUserName();
    private static String password = DatabaseConnection.getPassword();
	
	public void insertReference(Networking networking) {
        try (Connection conn = DatabaseConnection.getConnection(url, userName, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO reference (term, description, topic, example) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, networking.getTerm());
            stmt.setString(2, networking.getDescription());
            stmt.setString(3, networking.getTopic());
            stmt.setString(4, networking.getExample());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Networking> getAllReferences() {
        List<Networking> networking = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(url, userName, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM reference")) {
            while (rs.next()) {
            	networking.add(new Networking(rs.getInt("id"), rs.getString("term"), rs.getString("description"), rs.getString("topic"), rs.getString("example")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return networking;
    }

}
