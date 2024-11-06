package com.day7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.day7.model.Bug;
import com.day7.prop.DatabaseConfig;

public class BugDAO {
    private Connection connection;

    public BugDAO() {
        try {
            connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Bug bug) {
        String sql = "INSERT INTO Bug (title, description, status, created_by, assigned_to, created_at) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bug.getTitle());
            statement.setString(2, bug.getDescription());
            statement.setString(3, bug.getStatus());
            statement.setInt(4, bug.getCreatedBy());
            statement.setInt(5, bug.getAssignedTo());
            statement.setTimestamp(6, bug.getCreatedAt());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bug findById(int id) {
        String sql = "SELECT * FROM Bug WHERE bug_id = ?";
        Bug bug = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                bug = new Bug(
                    resultSet.getInt("bug_id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("status"),
                    resultSet.getInt("created_by"),
                    resultSet.getInt("assigned_to"),
                    resultSet.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bug;
    }
}
