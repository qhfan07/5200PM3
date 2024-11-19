package dal;

import model.ConnectionManager;
import model.WearableItem;

import java.sql.*;

public class WearableItemDao {
    private final ConnectionManager connectionManager;

    public WearableItemDao() {
        this.connectionManager = new ConnectionManager();
    }

    public WearableItem getWearableItemByID(int itemID) throws SQLException {
        String query = "SELECT * FROM WearableItem WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, itemID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        
                        int requiredLevel = resultSet.getInt("requiredLevel");
                        String attributeBonuses = resultSet.getString("attributeBonuses");

                        return new WearableItem(
                            itemID,
                            "Unknown Item Name",
                            1,
                            0.0,
                            1, 
                            requiredLevel,
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

    public WearableItem create(WearableItem wearableItem) throws SQLException {
        String query = "INSERT INTO WearableItem (itemID, requiredLevel, attributeBonuses) VALUES (?, ?, ?)";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, wearableItem.getItemID());
                statement.setInt(2, wearableItem.getRequiredLevel());
                statement.setString(3, wearableItem.getAttributeBonuses());
                statement.executeUpdate();
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return wearableItem;
    }

    public WearableItem updateAttributeBonuses(WearableItem wearableItem, String newBonuses) throws SQLException {
        String query = "UPDATE WearableItem SET attributeBonuses = ? WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, newBonuses);
                statement.setInt(2, wearableItem.getItemID());
                statement.executeUpdate();
                wearableItem.setAttributeBonuses(newBonuses);
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return wearableItem;
    }

    public void delete(WearableItem wearableItem) throws SQLException {
        String query = "DELETE FROM WearableItem WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, wearableItem.getItemID());
                statement.executeUpdate();
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
    }
}
