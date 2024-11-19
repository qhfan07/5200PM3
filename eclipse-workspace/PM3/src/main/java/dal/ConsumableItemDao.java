package dal;

import model.ConnectionManager;
import model.ConsumableItem;

import java.sql.*;

public class ConsumableItemDao {
    private final ConnectionManager connectionManager;

    public ConsumableItemDao() {
        this.connectionManager = new ConnectionManager();
    }

    public ConsumableItem getConsumableItemByID(int itemID) throws SQLException {
        String query = "SELECT * FROM ConsumableItem WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, itemID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String description = resultSet.getString("description");
                        String attributeBonuses = resultSet.getString("attributeBonuses");

                        return new ConsumableItem(
                            itemID,
                            "Unknown Item Name",
                            1,
                            0.0,
                            1,
                            description,
                            attributeBonuses
                        );
                    }
                }
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return null;
    }


    public ConsumableItem create(ConsumableItem consumableItem) throws SQLException {
        String query = "INSERT INTO ConsumableItem (itemID, description, attributeBonuses) VALUES (?, ?, ?)";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, consumableItem.getItemID());
                statement.setString(2, consumableItem.getDescription());
                statement.setString(3, consumableItem.getAttributeBonuses());
                statement.executeUpdate();
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return consumableItem;
    }

    public ConsumableItem updateDescription(ConsumableItem consumableItem, String newDescription) throws SQLException {
        String query = "UPDATE ConsumableItem SET description = ? WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, newDescription);
                statement.setInt(2, consumableItem.getItemID());
                statement.executeUpdate();
                consumableItem.setDescription(newDescription);
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return consumableItem;
    }

    public void delete(ConsumableItem consumableItem) throws SQLException {
        String query = "DELETE FROM ConsumableItem WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, consumableItem.getItemID());
                statement.executeUpdate();
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
    }
}

