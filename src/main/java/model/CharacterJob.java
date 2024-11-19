package model;

public class CharacterJob {
	protected Character character;
	protected Job job;
	protected int level;
	protected int experiencePoints;
	protected int nextLevelExperience;
	protected boolean isUnlocked;

    public CharacterJob(Character character, Job job, int level, int experiencePoints, int nextLevelExperience, boolean isUnlocked) {
        this.character = character;
        this.job = job;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.nextLevelExperience = nextLevelExperience;
        this.isUnlocked = isUnlocked;
    }

    public CharacterJob(Character character, Job job) {
        this.character = character;
        this.job = job;
    }
    
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getNextLevelExperience() {
        return nextLevelExperience;
    }

    public void setNextLevelExperience(int nextLevelExperience) {
        this.nextLevelExperience = nextLevelExperience;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
    	this.isUnlocked = unlocked;
    }
}
