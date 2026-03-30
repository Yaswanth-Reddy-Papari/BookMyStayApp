package service;

import model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return confirmedReservations;
    }
}