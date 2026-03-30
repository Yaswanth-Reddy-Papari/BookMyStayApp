package service;

import model.InvalidBookingException;
import inventory.RoomInventory;

public class ReservationValidator {

    public void validate(String guestName, String roomType, RoomInventory inventory)
            throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty");
        }

        // Validate room type
        if (!(roomType.equalsIgnoreCase("Single")
                || roomType.equalsIgnoreCase("Double")
                || roomType.equalsIgnoreCase("Suite"))) {
            throw new InvalidBookingException("Invalid room type selected");
        }

        // Validate availability
        if (inventory.getAvailability(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for " + roomType);
        }
    }
}