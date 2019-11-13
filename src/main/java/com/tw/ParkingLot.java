package com.tw;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParkingLot {

    private int size;

    private Map<Ticket, Car> carList;

    public ParkingLot(int size) {
        this.size = size;
        this.carList = new HashMap<>();
    }


    public Ticket park(Car car) throws RuntimeException {

        if (carList.size() == size) {
            throw new RuntimeException("No Parking Lot");
        }
        Ticket ticket = new Ticket(car.getCarNumber());
        carList.put(ticket, car);
        return ticket;
    }

    public Car getCar(Ticket ticket) {
        Car car = carList.remove(ticket);
        if (car == null) {
            throw new RuntimeException("Invalid ticket");
        }
        return car;
    }
}
