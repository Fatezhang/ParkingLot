package com.tw;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParkingLot {

    private int size;

    private Map<Ticket, Car> garage;

    public ParkingLot(int size) {
        this.size = size;
        this.garage = new HashMap<>();
    }


    public Ticket park(Car car) throws RuntimeException {

        if (garage.size() == size) {
            throw new RuntimeException("No Parking Lot");
        }
        Ticket ticket = new Ticket(car.getCarNum());
        garage.put(ticket, car);
        return ticket;
    }

    public Car getCar(Ticket ticket) {
        Iterator<Map.Entry<Ticket, Car>> iterator = garage.entrySet().iterator();
        Car car = null;
        while (iterator.hasNext()) {
            Map.Entry<Ticket, Car> next = iterator.next();
            if (next.getKey().equals(ticket)) {
                car = next.getValue();
                iterator.remove();
            }
        }
        if (car == null) {
            throw new RuntimeException("Invalid ticket");
        }
        return car;
    }

    public int getLotNum() {
        return garage.size();
    }
}
