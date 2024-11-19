package model;

public class Player {
    protected int playerID;
    protected String playerName;
    protected String emailAddress;

    public Player(int playerID, String playerName, String emailAddress) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.emailAddress = emailAddress;
    }

    public Player(String playerName, String emailAddress) {
        this.playerName = playerName;
        this.emailAddress = emailAddress;
    }

    public Player(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
}

