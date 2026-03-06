import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    public void displayInventory() {
        System.out.println("\nHotel Room Inventory Status");

        for (String room : roomAvailability.keySet()) {
            System.out.println(room + " Available Rooms: " + roomAvailability.get(room));
        }
    }
}