package dao;

import model.*;
import java.sql.*;

public class PlayerDao {
    protected ConnectionManager connectionManager;
    private static PlayerDao instance = null;

    protected PlayerDao() {
        connectionManager = new ConnectionManager();
    }

    public static PlayerDao getInstance() {
        if(instance == null) {
            instance = new PlayerDao();
        }
        return instance;
    }

    public Player create(Player player) throws SQLException {
        String insertPlayer = "INSERT INTO Player(playerName, emailAddress) VALUES(?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertPlayer, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, player.getPlayerName());
            insertStmt.setString(2, player.getEmailAddress());
            insertStmt.executeUpdate();

            resultKey = insertStmt.getGeneratedKeys();
            int playerID = -1;
            if(resultKey.next()) {
                playerID = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            player.setPlayerID(playerID);
            return player;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) connection.close();
            if(insertStmt != null) insertStmt.close();
            if(resultKey != null) resultKey.close();
        }
    }

    public Player getPlayerByID(int playerID) throws SQLException {
        String selectPlayer = "SELECT playerID, playerName, emailAddress FROM Player WHERE playerID=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayer);
            selectStmt.setInt(1, playerID);
            results = selectStmt.executeQuery();
            if(results.next()) {
                int resultPlayerID = results.getInt("playerID");
                String playerName = results.getString("playerName");
                String emailAddress = results.getString("emailAddress");
                return new Player(resultPlayerID, playerName, emailAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) connection.close();
            if(selectStmt != null) selectStmt.close();
            if(results != null) results.close();
        }
        return null;
    }
}
