package model;

public class WearableItem extends Item {
    protected int requiredLevel;
    protected String attributeBonuses;

    // Constructors
    public WearableItem() {}

    public WearableItem(int itemID, String itemName, int maxStackSize, double vendorPrice, int itemLevel, int requiredLevel, String attributeBonuses) {
        super(itemID, itemName, maxStackSize, vendorPrice, itemLevel);
        this.requiredLevel = requiredLevel;
        this.attributeBonuses = attributeBonuses;
    }
    
    //Getters and setters
    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public String getAttributeBonuses() {
        return attributeBonuses;
    }

    public void setAttributeBonuses(String attributeBonuses) {
        this.attributeBonuses = attributeBonuses;
    }
}

