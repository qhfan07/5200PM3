package model;

public class Gear extends WearableItem {
    private int magicDefenseRating;
    private int defenseRating;

    // Constructors
    public Gear() {}

    public Gear(int itemID, String itemName, int maxStackSize, double vendorPrice, int itemLevel, int requiredLevel, String attributeBonuses, int magicDefenseRating, int defenseRating) {
        super(itemID, itemName, maxStackSize, vendorPrice, itemLevel, requiredLevel, attributeBonuses);
        this.magicDefenseRating = magicDefenseRating;
        this.defenseRating = defenseRating;
    }

    // Getters and Setters
    public int getMagicDefenseRating() {
        return magicDefenseRating;
    }

    public void setMagicDefenseRating(int magicDefenseRating) {
        this.magicDefenseRating = magicDefenseRating;
    }

    public int getDefenseRating() {
        return defenseRating;
    }

    public void setDefenseRating(int defenseRating) {
        this.defenseRating = defenseRating;
    }
}

