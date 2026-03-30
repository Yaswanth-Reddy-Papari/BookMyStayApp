package service;

import model.Reservation;
import inventory.RoomInventory;
import java.util.HashSet;
import java.util.Set;

public class RoomAllocationService {

    private Set<String> allocatedRoomIds = new HashSet<>();

    public String allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        if (inventory.getAvailability(roomType) <= 0) {
            System.out.println("No rooms available for " + roomType);
            return null;
        }

        String roomId = roomType + "-" + (allocatedRoomIds.size() + 1);

        while (allocatedRoomIds.contains(roomId)) {
            roomId = roomType + "-" + (allocatedRoomIds.size() + 1);
        }

        allocatedRoomIds.add(roomId);

        inventory.decreaseAvailability(roomType);

        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: "
                + roomId);

        return roomId;
    }
}