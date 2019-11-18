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
        List<ParkingLot> parkingLots = parkingLotList.stream().filter(lot -> lot.getCurrentParkNum() < lot.getSize()).collect(Collectors.<ParkingLot>toList());
        if (parkingLots.isEmpty()) {
            throw new RuntimeException("No carports to park");
        }
        Ticket ticket = Optional.ofNullable(parkingLots.get(0)).orElseThrow(RuntimeException::new).park(car);
        return ticket;
    }

    public Car pick(Ticket ticket) {
        ParkingLot parkingLot = parkingLotList.stream().filter(lot -> lot.getId() == ticket.getLotId()).collect(Collectors.<ParkingLot>toList()).get(0);
        Car car = parkingLot.getCar(ticket);
        return car;
    }
}
