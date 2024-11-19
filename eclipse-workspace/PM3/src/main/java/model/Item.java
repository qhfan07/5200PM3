package model;

public class Item {
    protected int itemID;
    protected String itemName;
    protected int maxStackSize;
    protected double vendorPrice;
    protected int itemLevel;

    public Item() {}

    public Item(int itemID, String itemName, int maxStackSize, double vendorPrice, int itemLevel) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.maxStackSize = maxStackSize;
        this.vendorPrice = vendorPrice;
        this.itemLevel = itemLevel;
    }

    // Getters and Setters
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }

    public double getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(double vendorPrice) {
        this.vendorPrice = vendorPrice;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }
}
