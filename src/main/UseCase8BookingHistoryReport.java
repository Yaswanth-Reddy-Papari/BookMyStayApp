package main;

import model.Reservation;
import service.BookingHistory;
import service.BookingReportService;

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting:");

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Simulate confirmed bookings (reuse UC6 logic idea)
        history.addReservation(new Reservation("Anil", "Single"));
        history.addReservation(new Reservation("Suresh", "Double"));
        history.addReservation(new Reservation("Mahesh", "Suite"));

        // Generate report
        reportService.generateReport(history);
    }
}