package model;

public class Character {
	protected int characterID;
	protected String firstName;
	protected String lastName;
	protected Player player;

    public Character(int characterID, String firstName, String lastName, Player player) {
        this.characterID = characterID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.player = player;
    }

    public Character(String firstName, String lastName, Player player) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.player = player;
    }

    public Character(int characterID) {
        this.characterID = characterID;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
