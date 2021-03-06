package com.tw;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingLot {

    private int size;

    private int id;

    private Map<Ticket, Car> carList;

    public ParkingLot(int size, int id) {
        this.size = size;
        this.id = id;
        this.carList = new HashMap<>();
    }


    public Ticket park(Car car) throws RuntimeException {

        if (carList.size() == size) {
            throw new RuntimeException("No Parking Lot");
        }
        Ticket ticket = new Ticket(car.getCarNumber(), id);
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

    public int getCurrentParkNum() {
        return carList.size();
    }

    public int getRemainingParkNum() {
        return this.getSize() - this.getCarList().size();
    }
}
