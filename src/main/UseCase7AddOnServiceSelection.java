package main;

import model.Service;
import service.AddOnServiceManager;

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection:");

        AddOnServiceManager manager = new AddOnServiceManager();

        // Assume reservation ID from UC6
        String reservationId = "Single-1";

        // Add services
        manager.addService(reservationId, new Service("Breakfast", 500));
        manager.addService(reservationId, new Service("Airport Pickup", 1000));

        // Calculate total cost
        double total = manager.calculateTotalCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + total);
    }
}