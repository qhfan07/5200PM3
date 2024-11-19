package model;

public class ConsumableItem extends Item {
    protected String description;
    protected String attributeBonuses;

    // Constructors
    public ConsumableItem() {}

    public ConsumableItem(int itemID, String itemName, int maxStackSize, double vendorPrice, int itemLevel, String description, String attributeBonuses) {
        super(itemID, itemName, maxStackSize, vendorPrice, itemLevel);
        this.description = description;
        this.attributeBonuses = attributeBonuses;
    }
    
    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttributeBonuses() {
        return attributeBonuses;
    }

    public void setAttributeBonuses(String attributeBonuses) {
        this.attributeBonuses = attributeBonuses;
    }
}
