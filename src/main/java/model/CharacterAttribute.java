package model;

public class CharacterAttribute {
	protected int attributeID;
	protected Character character;
	protected int maxHp;
	protected int maxMp;
	protected int currentHp;
	protected int currentMp;
	protected int strength;
	protected int dexterity;
	protected int vitality;
	protected int intelligence;
	protected int mind;
	protected int criticalHit;
	protected int determination;
	protected int directHitRate;
	protected int defense;
	protected int magicDefense;
	protected int attackPower;
	protected int skillSpeed;
	protected int attackMagicPotency;
	protected int healingMagicPotency;
	protected int spellSpeed;
	protected int averageItemLevel;
	protected int tenacity;
	protected int piety;

    public CharacterAttribute(int attributeID, Character character, int maxHp, int maxMp, int currentHp, int currentMp,
                              int strength, int dexterity, int vitality, int intelligence, int mind, int criticalHit,
                              int determination, int directHitRate, int defense, int magicDefense, int attackPower,
                              int skillSpeed, int attackMagicPotency, int healingMagicPotency, int spellSpeed,
                              int averageItemLevel, int tenacity, int piety) {
        this.attributeID = attributeID;
        this.character = character;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.currentHp = currentHp;
        this.currentMp = currentMp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.mind = mind;
        this.criticalHit = criticalHit;
        this.determination = determination;
        this.directHitRate = directHitRate;
        this.defense = defense;
        this.magicDefense = magicDefense;
        this.attackPower = attackPower;
        this.skillSpeed = skillSpeed;
        this.attackMagicPotency = attackMagicPotency;
        this.healingMagicPotency = healingMagicPotency;
        this.spellSpeed = spellSpeed;
        this.averageItemLevel = averageItemLevel;
        this.tenacity = tenacity;
        this.piety = piety;
    }

    public CharacterAttribute(Character character, int maxHp, int maxMp, int currentHp, int currentMp,
                              int strength, int dexterity, int vitality, int intelligence, int mind, int criticalHit,
                              int determination, int directHitRate, int defense, int magicDefense, int attackPower,
                              int skillSpeed, int attackMagicPotency, int healingMagicPotency, int spellSpeed,
                              int averageItemLevel, int tenacity, int piety) {
        this.character = character;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.currentHp = currentHp;
        this.currentMp = currentMp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.mind = mind;
        this.criticalHit = criticalHit;
        this.determination = determination;
        this.directHitRate = directHitRate;
        this.defense = defense;
        this.magicDefense = magicDefense;
        this.attackPower = attackPower;
        this.skillSpeed = skillSpeed;
        this.attackMagicPotency = attackMagicPotency;
        this.healingMagicPotency = healingMagicPotency;
        this.spellSpeed = spellSpeed;
        this.averageItemLevel = averageItemLevel;
        this.tenacity = tenacity;
        this.piety = piety;
    }

    public CharacterAttribute(int attributeID, Character character) {
        this.attributeID = attributeID;
        this.character = character;
    }
    
    public CharacterAttribute(int attributeID) {
        this.attributeID = attributeID;
    }

    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public int getCriticalHit() {
        return criticalHit;
    }

    public void setCriticalHit(int criticalHit) {
        this.criticalHit = criticalHit;
    }

    public int getDetermination() {
        return determination;
    }

    public void setDetermination(int determination) {
        this.determination = determination;
    }

    public int getDirectHitRate() {
        return directHitRate;
    }

    public void setDirectHitRate(int directHitRate) {
        this.directHitRate = directHitRate;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getSkillSpeed() {
        return skillSpeed;
    }

    public void setSkillSpeed(int skillSpeed) {
        this.skillSpeed = skillSpeed;
    }

    public int getAttackMagicPotency() {
        return attackMagicPotency;
    }

    public void setAttackMagicPotency(int attackMagicPotency) {
        this.attackMagicPotency = attackMagicPotency;
    }

    public int getHealingMagicPotency() {
        return healingMagicPotency;
    }

    public void setHealingMagicPotency(int healingMagicPotency) {
        this.healingMagicPotency = healingMagicPotency;
    }

    public int getSpellSpeed() {
        return spellSpeed;
    }

    public void setSpellSpeed(int spellSpeed) {
        this.spellSpeed = spellSpeed;
    }

    public int getAverageItemLevel() {
        return averageItemLevel;
    }

    public void setAverageItemLevel(int averageItemLevel) {
        this.averageItemLevel = averageItemLevel;
    }

    public int getTenacity() {
        return tenacity;
    }

    public void setTenacity(int tenacity) {
        this.tenacity = tenacity;
    }

    public int getPiety() {
        return piety;
    }

    public void setPiety(int piety) {
        this.piety = piety;
    }
}

       
