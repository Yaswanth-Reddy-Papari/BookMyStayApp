package main;

import model.Reservation;
import service.*;
import inventory.RoomInventory;

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation:");

        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Initialize inventory
        inventory.addRoomType("Single", 2);
        inventory.addRoomType("Double", 2);
        inventory.addRoomType("Suite", 1);

        // Add booking requests
        queue.addRequest(new Reservation("Anil", "Single"));
        queue.addRequest(new Reservation("Suresh", "Double"));
        queue.addRequest(new Reservation("Mahesh", "Suite"));
        queue.addRequest(new Reservation("Rahul", "Single"));
        queue.addRequest(new Reservation("Kiran", "Double"));

        // Create threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(queue, inventory, allocationService));

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(queue, inventory, allocationService));

        // Start threads
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));
        System.out.println("Suite: " + inventory.getAvailability("Suite"));
    }
}