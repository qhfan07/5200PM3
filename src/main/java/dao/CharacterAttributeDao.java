package dao;

import model.*;
import model.Character;
import java.sql.*;


public class CharacterAttributeDao {
    protected ConnectionManager connectionManager;
    private static CharacterAttributeDao instance = null;

    protected CharacterAttributeDao() {
        connectionManager = new ConnectionManager();
    }

    public static CharacterAttributeDao getInstance() {
        if (instance == null) {
            instance = new CharacterAttributeDao();
        }
        return instance;
    }

    public CharacterAttribute create(CharacterAttribute characterAttribute) throws SQLException {
        String insertCharacterAttribute = 
            "INSERT INTO CharacterAttribute(" +
            "characterID, maxHp, maxMp, currentHp, currentMp, strength, dexterity, vitality, " +
            "intelligence, mind, criticalHit, determination, directHitRate, defense, " +
            "magicDefense, attackPower, skillSpeed, attackMagicPotency, healingMagicPotency, " +
            "spellSpeed, averageItemLevel, tenacity, piety) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertCharacterAttribute, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setInt(1, characterAttribute.getCharacter().getCharacterID());
            insertStmt.setInt(2, characterAttribute.getMaxHp());
            insertStmt.setInt(3, characterAttribute.getMaxMp());
            insertStmt.setInt(4, characterAttribute.getCurrentHp());
            insertStmt.setInt(5, characterAttribute.getCurrentMp());
            insertStmt.setInt(6, characterAttribute.getStrength());
            insertStmt.setInt(7, characterAttribute.getDexterity());
            insertStmt.setInt(8, characterAttribute.getVitality());
            insertStmt.setInt(9, characterAttribute.getIntelligence());
            insertStmt.setInt(10, characterAttribute.getMind());
            insertStmt.setInt(11, characterAttribute.getCriticalHit());
            insertStmt.setInt(12, characterAttribute.getDetermination());
            insertStmt.setInt(13, characterAttribute.getDirectHitRate());
            insertStmt.setInt(14, characterAttribute.getDefense());
            insertStmt.setInt(15, characterAttribute.getMagicDefense());
            insertStmt.setInt(16, characterAttribute.getAttackPower());
            insertStmt.setInt(17, characterAttribute.getSkillSpeed());
            insertStmt.setInt(18, characterAttribute.getAttackMagicPotency());
            insertStmt.setInt(19, characterAttribute.getHealingMagicPotency());
            insertStmt.setInt(20, characterAttribute.getSpellSpeed());
            insertStmt.setInt(21, characterAttribute.getAverageItemLevel());
            insertStmt.setInt(22, characterAttribute.getTenacity());
            insertStmt.setInt(23, characterAttribute.getPiety());
            insertStmt.executeUpdate();

            resultKey = insertStmt.getGeneratedKeys();
            int attributeID = -1;
            if (resultKey.next()) {
                attributeID = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            characterAttribute.setAttributeID(attributeID);
            return characterAttribute;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) connection.close();
            if (insertStmt != null) insertStmt.close();
            if (resultKey != null) resultKey.close();
        }
    }

    public CharacterAttribute getCharacterAttributeByID(int attributeID, int characterID) throws SQLException {
        String selectCharacterAttribute = 
            "SELECT attributeID, characterID, maxHp, maxMp, currentHp, currentMp, strength, dexterity, vitality, " +
            "intelligence, mind, criticalHit, determination, directHitRate, defense, magicDefense, " +
            "attackPower, skillSpeed, attackMagicPotency, healingMagicPotency, spellSpeed, " +
            "averageItemLevel, tenacity, piety " +
            "FROM CharacterAttribute " +
            "WHERE attributeID = ? AND characterID = ?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectCharacterAttribute);
            selectStmt.setInt(1, attributeID);
            selectStmt.setInt(2, characterID);
            results = selectStmt.executeQuery();

            CharacterDao characterDao = CharacterDao.getInstance();
            if (results.next()) {
                int resultAttributeID = results.getInt("attributeID");
                int resultCharacterID = results.getInt("characterID");
                Character character = characterDao.getCharacterByID(resultCharacterID);
                int maxHp = results.getInt("maxHp");
                int maxMp = results.getInt("maxMp");
                int currentHp = results.getInt("currentHp");
                int currentMp = results.getInt("currentMp");
                int strength = results.getInt("strength");
                int dexterity = results.getInt("dexterity");
                int vitality = results.getInt("vitality");
                int intelligence = results.getInt("intelligence");
                int mind = results.getInt("mind");
                int criticalHit = results.getInt("criticalHit");
                int determination = results.getInt("determination");
                int directHitRate = results.getInt("directHitRate");
                int defense = results.getInt("defense");
                int magicDefense = results.getInt("magicDefense");
                int attackPower = results.getInt("attackPower");
                int skillSpeed = results.getInt("skillSpeed");
                int attackMagicPotency = results.getInt("attackMagicPotency");
                int healingMagicPotency = results.getInt("healingMagicPotency");
                int spellSpeed = results.getInt("spellSpeed");
                int averageItemLevel = results.getInt("averageItemLevel");
                int tenacity = results.getInt("tenacity");
                int piety = results.getInt("piety");

                return new CharacterAttribute(resultAttributeID, character, maxHp, maxMp, currentHp, currentMp,
                    strength, dexterity, vitality, intelligence, mind, criticalHit, determination, directHitRate,
                    defense, magicDefense, attackPower, skillSpeed, attackMagicPotency, healingMagicPotency,
                    spellSpeed, averageItemLevel, tenacity, piety);
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

