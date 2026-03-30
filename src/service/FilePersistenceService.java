package service;

import inventory.RoomInventory;
import java.io.*;

public class FilePersistenceService {

    // Save inventory to file
    public void saveInventory(RoomInventory inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("Single=" + inventory.getAvailability("Single"));
            writer.newLine();

            writer.write("Double=" + inventory.getAvailability("Double"));
            writer.newLine();

            writer.write("Suite=" + inventory.getAvailability("Suite"));
            writer.newLine();

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load inventory from file
    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No saved inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    inventory.addRoomType(roomType, count);
                }
            }

            System.out.println("Inventory loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}