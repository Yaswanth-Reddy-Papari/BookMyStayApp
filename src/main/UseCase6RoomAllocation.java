package main;
import model.Reservation;
import service.BookingRequestQueue;
import service.RoomAllocationService;
import inventory.RoomInventory;

public class UseCase6RoomAllocation {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing:");

        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocator = new RoomAllocationService();

        // IMPORTANT: initialize inventory
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);

        queue.addRequest(new Reservation("Anil", "Single"));
        queue.addRequest(new Reservation("Suresh", "Double"));
        queue.addRequest(new Reservation("Mahesh", "Suite"));

        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocator.allocateRoom(r, inventory);
        }
    }
}