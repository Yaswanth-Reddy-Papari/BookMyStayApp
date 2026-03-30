package main;

import model.Reservation;
import service.BookingRequestQueue;

public class UseCase5BookingRequest {

    public static void main(String[] args) {

        System.out.println("Booking Request Queue:");

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Anil", "Single"));
        queue.addRequest(new Reservation("Suresh", "Double"));
        queue.addRequest(new Reservation("Mahesh", "Suite"));

        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            System.out.println("Processing booking for Guest: "
                    + r.getGuestName()
                    + ", Room Type: "
                    + r.getRoomType());
        }
    }
}