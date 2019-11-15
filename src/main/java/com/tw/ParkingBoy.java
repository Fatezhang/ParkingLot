package com.tw;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingBoy {

    List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLotList.stream().filter(lot -> lot.getCurrentParkNum() < lot.getSize()).collect(Collectors.<ParkingLot>toList()).get(0);
        Ticket ticket = Optional.ofNullable(parkingLot).orElseThrow(RuntimeException::new).park(car);
        return ticket;
    }

    public Car pick(Ticket ticket) {
        ParkingLot parkingLot = parkingLotList.stream().filter(lot -> lot.getId() == ticket.getLotId()).collect(Collectors.<ParkingLot>toList()).get(0);
        Car car = parkingLot.getCar(ticket);
        return car;
    }
}
