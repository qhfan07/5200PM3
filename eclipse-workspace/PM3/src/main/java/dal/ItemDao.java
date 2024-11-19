package dal;

import model.ConnectionManager;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private final ConnectionManager connectionManager;

    public ItemDao() {
        this.connectionManager = new ConnectionManager();
    }

    public Item getItemByID(int itemID) throws SQLException {
        String query = "SELECT * FROM Item WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, itemID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Item(
                            resultSet.getInt("itemID"),
                            resultSet.getString("itemName"),
                            resultSet.getInt("maxStackSize"),
                            resultSet.getDouble("vendorPrice"),
                            resultSet.getInt("itemLevel")
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

    public Item create(Item item) throws SQLException {
        String query = "INSERT INTO Item (itemName, maxStackSize, vendorPrice, itemLevel) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, item.getItemName());
                statement.setInt(2, item.getMaxStackSize());
                statement.setDouble(3, item.getVendorPrice());
                statement.setInt(4, item.getItemLevel());
                statement.executeUpdate();

                try (ResultSet keys = statement.getGeneratedKeys()) {
                    if (keys.next()) {
                        item.setItemID(keys.getInt(1));
                    }
                }
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return item;
    }

    public List<Item> getItemsByPartialName(String name) throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM Item WHERE itemName LIKE ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + name + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        items.add(new Item(
                            resultSet.getInt("itemID"),
                            resultSet.getString("itemName"),
                            resultSet.getInt("maxStackSize"),
                            resultSet.getDouble("vendorPrice"),
                            resultSet.getInt("itemLevel")
                        ));
                    }
                }
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return items;
    }

    public Item updateVendorPrice(Item item, double newPrice) throws SQLException {
        String query = "UPDATE Item SET vendorPrice = ? WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, newPrice);
                statement.setInt(2, item.getItemID());
                statement.executeUpdate();
                item.setVendorPrice(newPrice);
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return item;
    }

    public void delete(Item item) throws SQLException {
        String query = "DELETE FROM Item WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, item.getItemID());
                statement.executeUpdate();
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
    }	
}
