package main;

import inventory.RoomInventory;
import service.CancellationService;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation:");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancelService = new CancellationService();

        // Initial inventory
        inventory.addRoomType("Single", 5);

        // Simulate confirmed booking (from UC6)
        String reservationId = "Single-1";
        cancelService.registerBooking(reservationId, "Single");

        // Cancel booking
        cancelService.cancelBooking(reservationId, inventory);

        // Show rollback history
        cancelService.showRollbackHistory();

        // Show updated inventory
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getAvailability("Single"));
    }
}