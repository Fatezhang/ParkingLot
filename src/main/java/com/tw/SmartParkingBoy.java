package com.tw;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public Ticket park(Car carNumber) {
        ParkingLot parkingLot = parkingLots.stream().filter(lot -> lot.getCurrentParkNum() < lot.getSize()).max(ParkingLot::compareTo).get();
        return parkingLot.park(carNumber);
    }

    public Car pick(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream().filter(lot -> lot.getId() == ticket.getLotId()).collect(Collectors.<ParkingLot>toList()).get(0);
        return parkingLot.getCar(ticket);
    }
}
