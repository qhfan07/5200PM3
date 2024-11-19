package dao;

import model.Character;
import model.*;
import java.sql.*;

public class CharacterDao {
    protected ConnectionManager connectionManager;
    private static CharacterDao instance = null;

    protected CharacterDao() {
        connectionManager = new ConnectionManager();
    }

    public static CharacterDao getInstance() {
        if (instance == null) {
            instance = new CharacterDao();
        }
        return instance;
    }

    public Character create(Character character) throws SQLException {
        String insertCharacter = "INSERT INTO `Character`(firstName, lastName, playerID) VALUES(?, ?, ?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertCharacter, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, character.getFirstName());
            insertStmt.setString(2, character.getLastName());
            insertStmt.setInt(3, character.getPlayer().getPlayerID());
            insertStmt.executeUpdate();

            resultKey = insertStmt.getGeneratedKeys();
            int characterID = -1;
            if (resultKey.next()) {
                characterID = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            character.setCharacterID(characterID);
            return character;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) connection.close();
            if (insertStmt != null) insertStmt.close();
            if (resultKey != null) resultKey.close();
        }
    }

    public Character getCharacterByID(int characterID) throws SQLException {
        String selectCharacter = "SELECT characterID, firstName, lastName, playerID FROM `Character` WHERE characterID = ?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectCharacter);
            selectStmt.setInt(1, characterID);
            results = selectStmt.executeQuery();
            PlayerDao playerDao = PlayerDao.getInstance();
            if (results.next()) {
                int resultCharacterID = results.getInt("characterID");
                String firstName = results.getString("firstName");
                String lastName = results.getString("lastName");
                int playerID = results.getInt("playerID");
                
                Player player = playerDao.getPlayerByID(playerID);
                Character character = new Character(resultCharacterID, firstName, lastName, player);
                return character;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) connection.close();
            if (selectStmt != null) selectStmt.close();
            if (results != null) results.close();
        }
        return null;
    }
}
