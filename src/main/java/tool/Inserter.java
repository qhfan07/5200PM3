package tool;

import dao.*;
import model.*;
import model.Character;
import java.sql.SQLException;

public class Inserter {
    public static void main(String[] args) throws SQLException {
        // DAO instances
        PlayerDao playerDao = PlayerDao.getInstance();
        CharacterDao characterDao = CharacterDao.getInstance();
        JobDao jobDao = JobDao.getInstance();
        CharacterAttributeDao characterAttributeDao = CharacterAttributeDao.getInstance();
        CharacterJobDao characterJobDao = CharacterJobDao.getInstance();

        // INSERT operations for Player
        Player player1 = new Player("UniqueHeroPlayer1", "unique_hero1@example.com");
        player1 = playerDao.create(player1);
        System.out.println("Created Player 1: ID=" + player1.getPlayerID() + ", Name=" + player1.getPlayerName());

        Player player2 = new Player("UniqueHeroPlayer2", "unique_hero2@example.com");
        player2 = playerDao.create(player2);
        System.out.println("Created Player 2: ID=" + player2.getPlayerID() + ", Name=" + player2.getPlayerName());

        // INSERT operations for Character associated with Players
        Character character1 = new Character("WarriorOne", "SmithOne", player1);
        character1 = characterDao.create(character1);
        System.out.println("Created Character 1: ID=" + character1.getCharacterID() + ", Name=" + character1.getFirstName() + " " + character1.getLastName());

        Character character2 = new Character("WarriorTwo", "SmithTwo", player2);
        character2 = characterDao.create(character2);
        System.out.println("Created Character 2: ID=" + character2.getCharacterID() + ", Name=" + character2.getFirstName() + " " + character2.getLastName());

        // INSERT operations for Job
        Job job1 = new Job("UniqueMage1", "Magic User", 60);
        job1 = jobDao.create(job1);
        System.out.println("Created Job 1: ID=" + job1.getJobID() + ", Name=" + job1.getJobName());

        Job job2 = new Job("UniqueMage2", "Magic User", 70);
        job2 = jobDao.create(job2);
        System.out.println("Created Job 2: ID=" + job2.getJobID() + ", Name=" + job2.getJobName());

        // INSERT operations for CharacterAttribute for Characters
        CharacterAttribute characterAttribute1 = new CharacterAttribute(
            character1, 1200, 800, 1100, 750, 50, 45, 40, 35, 30, 
            25, 20, 15, 60, 70, 80, 25, 30, 35, 10, 150, 10, 5
        );
        characterAttribute1 = characterAttributeDao.create(characterAttribute1);
        System.out.println("Created CharacterAttribute 1: ID=" + characterAttribute1.getAttributeID() + ", MaxHp=" + characterAttribute1.getMaxHp());

        CharacterAttribute characterAttribute2 = new CharacterAttribute(
            character2, 1300, 900, 1200, 850, 60, 55, 50, 45, 40, 
            35, 30, 25, 70, 80, 90, 35, 40, 45, 20, 160, 20, 15
        );
        characterAttribute2 = characterAttributeDao.create(characterAttribute2);
        System.out.println("Created CharacterAttribute 2: ID=" + characterAttribute2.getAttributeID() + ", MaxHp=" + characterAttribute2.getMaxHp());

        // INSERT operations for CharacterJob
        CharacterJob characterJob1 = new CharacterJob(character1, job1, 15, 2000, 3000, true);
        characterJob1 = characterJobDao.create(characterJob1);
        System.out.println("Created CharacterJob 1: CharacterID=" + characterJob1.getCharacter().getCharacterID() + ", JobID=" + characterJob1.getJob().getJobID());

        CharacterJob characterJob2 = new CharacterJob(character2, job2, 20, 2500, 4000, false);
        characterJob2 = characterJobDao.create(characterJob2);
        System.out.println("Created CharacterJob 2: CharacterID=" + characterJob2.getCharacter().getCharacterID() + ", JobID=" + characterJob2.getJob().getJobID());

        // READ operations using DAOs
        // Retrieve Players by ID
        Player retrievedPlayer1 = playerDao.getPlayerByID(player1.getPlayerID());
        if (retrievedPlayer1 != null) {
            System.out.println("Retrieved Player 1: ID=" + retrievedPlayer1.getPlayerID() + ", Name=" + retrievedPlayer1.getPlayerName());
        }
        Player retrievedPlayer2 = playerDao.getPlayerByID(player2.getPlayerID());
        if (retrievedPlayer2 != null) {
            System.out.println("Retrieved Player 2: ID=" + retrievedPlayer2.getPlayerID() + ", Name=" + retrievedPlayer2.getPlayerName());
        }

        // Retrieve Characters by ID
        Character retrievedCharacter1 = characterDao.getCharacterByID(character1.getCharacterID());
        if (retrievedCharacter1 != null) {
            System.out.println("Retrieved Character 1: ID=" + retrievedCharacter1.getCharacterID() + ", Name=" + retrievedCharacter1.getFirstName() + " " + retrievedCharacter1.getLastName());
        }
        Character retrievedCharacter2 = characterDao.getCharacterByID(character2.getCharacterID());
        if (retrievedCharacter2 != null) {
            System.out.println("Retrieved Character 2: ID=" + retrievedCharacter2.getCharacterID() + ", Name=" + retrievedCharacter2.getFirstName() + " " + retrievedCharacter2.getLastName());
        }

        // Retrieve Jobs by ID
        Job retrievedJob1 = jobDao.getJobByID(job1.getJobID());
        if (retrievedJob1 != null) {
            System.out.println("Retrieved Job 1: ID=" + retrievedJob1.getJobID() + ", Name=" + retrievedJob1.getJobName());
        }
        Job retrievedJob2 = jobDao.getJobByID(job2.getJobID());
        if (retrievedJob2 != null) {
            System.out.println("Retrieved Job 2: ID=" + retrievedJob2.getJobID() + ", Name=" + retrievedJob2.getJobName());
        }

        // Retrieve CharacterAttributes by ID
        CharacterAttribute retrievedCharacterAttribute1 = characterAttributeDao.getCharacterAttributeByID(characterAttribute1.getAttributeID(), character1.getCharacterID());
        if (retrievedCharacterAttribute1 != null) {
            System.out.println("Retrieved CharacterAttribute 1: MaxHp=" + retrievedCharacterAttribute1.getMaxHp() + ", Strength=" + retrievedCharacterAttribute1.getStrength());
        }
        CharacterAttribute retrievedCharacterAttribute2 = characterAttributeDao.getCharacterAttributeByID(characterAttribute2.getAttributeID(), character2.getCharacterID());
        if (retrievedCharacterAttribute2 != null) {
            System.out.println("Retrieved CharacterAttribute 2: MaxHp=" + retrievedCharacterAttribute2.getMaxHp() + ", Strength=" + retrievedCharacterAttribute2.getStrength());
        }

        // Retrieve CharacterJobs by Character and Job
        CharacterJob retrievedCharacterJob1 = characterJobDao.getCharacterJobByCharacterAndJob(character1, job1);
        if (retrievedCharacterJob1 != null) {
            System.out.println("Retrieved CharacterJob 1: Level=" + retrievedCharacterJob1.getLevel() + ", ExperiencePoints=" + retrievedCharacterJob1.getExperiencePoints());
        }
        CharacterJob retrievedCharacterJob2 = characterJobDao.getCharacterJobByCharacterAndJob(character2, job2);
        if (retrievedCharacterJob2 != null) {
            System.out.println("Retrieved CharacterJob 2: Level=" + retrievedCharacterJob2.getLevel() + ", ExperiencePoints=" + retrievedCharacterJob2.getExperiencePoints());
        }
        
        // DELETE operation for CharacterJob
        characterJobDao.delete(characterJob1);
        System.out.println("Deleted CharacterJob 1 for CharacterID=" + characterJob1.getCharacter().getCharacterID() + ", JobID=" + characterJob1.getJob().getJobID());

        // Verify deletion
        CharacterJob deletedCharacterJob1 = characterJobDao.getCharacterJobByCharacterAndJob(character1, job1);
        if (deletedCharacterJob1 == null) {
            System.out.println("Verified deletion of CharacterJob 1");
        }
    }
}
