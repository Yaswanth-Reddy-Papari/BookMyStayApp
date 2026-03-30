package service;

import java.util.*;

import inventory.RoomInventory;

public class CancellationService {

    // Stack for rollback tracking
    private Stack<String> releasedRoomIds;

    // reservationId → roomType
    private Map<String, String> reservationMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationMap = new HashMap<>();
    }

    // Register confirmed booking
    public void registerBooking(String reservationId, String roomType) {
        reservationMap.put(reservationId, roomType);
    }

    // Cancel booking
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation: Reservation not found");
            return;
        }

        String roomType = reservationMap.get(reservationId);

        // Restore inventory
        inventory.addRoomType(roomType,
                inventory.getAvailability(roomType) + 1);

        // Track rollback
        releasedRoomIds.push(reservationId);

        // Remove booking
        reservationMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    // Show rollback history
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");

        for (String id : releasedRoomIds) {
            System.out.println("Released Reservation ID: " + id);
        }
    }
}