package main;

import inventory.RoomInventory;
import service.FilePersistenceService;

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery:");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();

        String filePath = "inventory.txt";

        // Load existing data
        persistence.loadInventory(inventory, filePath);

        // If fresh start, initialize
        if (inventory.getAvailability("Single") == 0
                && inventory.getAvailability("Double") == 0
                && inventory.getAvailability("Suite") == 0) {

            inventory.addRoomType("Single", 5);
            inventory.addRoomType("Double", 3);
            inventory.addRoomType("Suite", 2);
        }

        // Display inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));
        System.out.println("Suite: " + inventory.getAvailability("Suite"));

        // Save before exit
        persistence.saveInventory(inventory, filePath);
    }
}