package tools;

import dal.*;
import model.*;
import model.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();

        try (Connection connection = connectionManager.getConnection()) {
            System.out.println("Database connected successfully!");

            // Initialize DAOs
            ItemDao itemDao = new ItemDao();
            WearableItemDao wearableItemDao = new WearableItemDao();
            ConsumableItemDao consumableItemDao = new ConsumableItemDao();
            GearDao gearDao = new GearDao();

            // --- Test ItemDao ---
            System.out.println("\n--- Testing ItemDao ---");

            // Create a new Item
            Item newItem = new Item(0, "Health Potion", 10, 50.0, 5);
            newItem = itemDao.create(newItem); // Insert into Item table
            System.out.println("Created Item: " + newItem);

            // Fetch Item by ID
            Item fetchedItem = itemDao.getItemByID(newItem.getItemID());
            System.out.println("Fetched Item: " + fetchedItem);

            // Update Item's vendorPrice
            fetchedItem = itemDao.updateVendorPrice(fetchedItem, 75.0);
            System.out.println("Updated Item: " + fetchedItem);

            // Search Items by partial name
            List<Item> items = itemDao.getItemsByPartialName("Potion");
            System.out.println("Items found: " + items);

            // --- Test WearableItemDao ---
            System.out.println("\n--- Testing WearableItemDao ---");

            // Create a new WearableItem using the itemID
            WearableItem newWearableItem = new WearableItem(
                newItem.getItemID(), // Use the itemID from the created Item
                newItem.getItemName(),
                newItem.getMaxStackSize(),
                newItem.getVendorPrice(),
                newItem.getItemLevel(),
                10, // requiredLevel
                "Defense+10" // attributeBonuses
            );
            newWearableItem = wearableItemDao.create(newWearableItem);
            System.out.println("Created WearableItem: " + newWearableItem);

            // Fetch WearableItem by ID
            WearableItem fetchedWearableItem = wearableItemDao.getWearableItemByID(newWearableItem.getItemID());
            System.out.println("Fetched WearableItem: " + fetchedWearableItem);

            // Update attribute bonuses
            fetchedWearableItem = wearableItemDao.updateAttributeBonuses(fetchedWearableItem, "Defense+15");
            System.out.println("Updated WearableItem: " + fetchedWearableItem);

            // --- Test ConsumableItemDao ---
            System.out.println("\n--- Testing ConsumableItemDao ---");

            // Create a new ConsumableItem using the itemID
            ConsumableItem newConsumableItem = new ConsumableItem(
                newItem.getItemID(), // Use the itemID from the created Item
                newItem.getItemName(),
                newItem.getMaxStackSize(),
                newItem.getVendorPrice(),
                newItem.getItemLevel(),
                "Restores 50 HP", // Description
                "Health+50" // Attribute Bonuses
            );
            newConsumableItem = consumableItemDao.create(newConsumableItem);
            System.out.println("Created ConsumableItem: " + newConsumableItem);

            // Fetch ConsumableItem by ID
            ConsumableItem fetchedConsumableItem = consumableItemDao.getConsumableItemByID(newConsumableItem.getItemID());
            System.out.println("Fetched ConsumableItem: " + fetchedConsumableItem);

            // Update ConsumableItem description
            fetchedConsumableItem = consumableItemDao.updateDescription(fetchedConsumableItem, "Restores 100 HP");
            System.out.println("Updated ConsumableItem: " + fetchedConsumableItem);

            // --- Test GearDao ---
            System.out.println("\n--- Testing GearDao ---");

            // Create a new Gear using the itemID
            Gear newGear = new Gear(
                newItem.getItemID(), // Use the itemID from the created Item
                newItem.getItemName(),
                newItem.getMaxStackSize(),
                newItem.getVendorPrice(),
                newItem.getItemLevel(),
                15, // requiredLevel
                "Block+10", // Attribute Bonuses
                50, // Magic Defense Rating
                30 // Defense Rating
            );
            newGear = gearDao.create(newGear);
            System.out.println("Created Gear: " + newGear);

            // Fetch Gear by ID
            Gear fetchedGear = gearDao.getGearByID(newGear.getItemID());
            System.out.println("Fetched Gear: " + fetchedGear);

            // --- Cleanup ---
            System.out.println("\n--- Cleaning Up ---");

            // Delete Gear
            gearDao.delete(fetchedGear);
            System.out.println("Deleted Gear with ID: " + fetchedGear.getItemID());

            // Delete ConsumableItem
            consumableItemDao.delete(fetchedConsumableItem);
            System.out.println("Deleted ConsumableItem with ID: " + fetchedConsumableItem.getItemID());

            // Delete WearableItem
            wearableItemDao.delete(fetchedWearableItem);
            System.out.println("Deleted WearableItem with ID: " + fetchedWearableItem.getItemID());

            // Delete Item
            itemDao.delete(fetchedItem);
            System.out.println("Deleted Item with ID: " + fetchedItem.getItemID());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
