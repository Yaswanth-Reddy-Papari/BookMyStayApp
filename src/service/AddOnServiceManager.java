package service;

import model.Service;
import java.util.*;

public class AddOnServiceManager {

    // reservationId → list of services
    private Map<String, List<Service>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added service: " + service.getServiceName()
                + " to Reservation: " + reservationId);
    }

    public double calculateTotalCost(String reservationId) {

        double total = 0;

        if (serviceMap.containsKey(reservationId)) {
            for (Service s : serviceMap.get(reservationId)) {
                total += s.getCost();
            }
        }

        return total;
    }
}