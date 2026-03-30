package inventory;
import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
    }

    // UC3 method (keep this)
    public void addRoomType(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    // UC6 needs this
    public int getAvailability(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    // UC6 needs this
    public void decreaseAvailability(String roomType) {
        if (roomAvailability.containsKey(roomType)) {
            int count = roomAvailability.get(roomType);
            if (count > 0) {
                roomAvailability.put(roomType, count - 1);
            }
        }
    }

    // UC3 method (keep this)
    public void displayInventory() {
        System.out.println("\nHotel Room Inventory Status");

        for (String room : roomAvailability.keySet()) {
            System.out.println(room + " Available Rooms: " + roomAvailability.get(room));
        }
    }
}