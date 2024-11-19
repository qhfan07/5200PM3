package dao;

import model.*;
import model.Character;
import java.sql.*;


public class CharacterJobDao {
    protected ConnectionManager connectionManager;

    private static CharacterJobDao instance = null;

    protected CharacterJobDao() {
        connectionManager = new ConnectionManager();
    }

    public static CharacterJobDao getInstance() {
        if (instance == null) {
            instance = new CharacterJobDao();
        }
        return instance;
    }

    public CharacterJob create(CharacterJob characterJob) throws SQLException {
        String insertCharacterJob = 
            "INSERT INTO CharacterJob(characterID, jobID, level, experiencePoints, nextLevelExperience, isUnlocked) " +
            "VALUES(?, ?, ?, ?, ?, ?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertCharacterJob);
            insertStmt.setInt(1, characterJob.getCharacter().getCharacterID());
            insertStmt.setInt(2, characterJob.getJob().getJobID());
            insertStmt.setInt(3, characterJob.getLevel());
            insertStmt.setInt(4, characterJob.getExperiencePoints());
            insertStmt.setInt(5, characterJob.getNextLevelExperience());
            insertStmt.setBoolean(6, characterJob.isUnlocked());
            insertStmt.executeUpdate();
            return characterJob;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }

    public CharacterJob getCharacterJobByCharacterAndJob(Character character, Job job) throws SQLException {
        String selectCharacterJob = 
            "SELECT characterID, jobID, level, experiencePoints, nextLevelExperience, isUnlocked " +
            "FROM CharacterJob " +
            "WHERE characterID = ? AND jobID = ?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectCharacterJob);
            selectStmt.setInt(1, character.getCharacterID());
            selectStmt.setInt(2, job.getJobID());
            results = selectStmt.executeQuery();
            if (results.next()) {
                int level = results.getInt("level");
                int experiencePoints = results.getInt("experiencePoints");
                int nextLevelExperience = results.getInt("nextLevelExperience");
                boolean isUnlocked = results.getBoolean("isUnlocked");

                return new CharacterJob(character, job, level, experiencePoints, nextLevelExperience, isUnlocked);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (results != null) {
                results.close();
            }
        }
        return null;
    }
    
    public CharacterJob delete(CharacterJob characterJob) throws SQLException {
        String deleteCharacterJob = "DELETE FROM CharacterJob WHERE characterID=? AND jobID=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteCharacterJob);
            deleteStmt.setInt(1, characterJob.getCharacter().getCharacterID());
            deleteStmt.setInt(2, characterJob.getJob().getJobID());
            deleteStmt.executeUpdate();

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (deleteStmt != null) {
                deleteStmt.close();
            }
        }
    }


}