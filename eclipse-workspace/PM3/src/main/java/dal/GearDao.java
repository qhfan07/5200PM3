package dal;

import model.ConnectionManager;
import model.Gear;

import java.sql.*;

public class GearDao {
    private final ConnectionManager connectionManager;

    public GearDao() {
        this.connectionManager = new ConnectionManager();
    }

    public Gear getGearByID(int itemID) throws SQLException {
        String query = "SELECT * FROM Gear WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, itemID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int magicDefenseRating = resultSet.getInt("magicDefenseRating");
                        int defenseRating = resultSet.getInt("defenseRating");

                        return new Gear(
                            itemID,
                            "Unknown Item Name",
                            1,
                            0.0,
                            1,
                            1,
                            "Unknown Bonuses",
                            magicDefenseRating,
                            defenseRating
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

    public Gear create(Gear gear) throws SQLException {
        String query = "INSERT INTO Gear (itemID, magicDefenseRating, defenseRating) VALUES (?, ?, ?)";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gear.getItemID());
                statement.setInt(2, gear.getMagicDefenseRating());
                statement.setInt(3, gear.getDefenseRating());
                statement.executeUpdate();
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
        return gear;
    }

    public void delete(Gear gear) throws SQLException {
        String query = "DELETE FROM Gear WHERE itemID = ?";
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gear.getItemID());
                statement.executeUpdate();
            }
        } finally {
            if (connection != null) {
                connectionManager.closeConnection(connection);
            }
        }
    }
}
