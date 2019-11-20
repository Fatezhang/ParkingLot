package com.tw;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public Ticket park(Car carNumber) {
        return parkingLots.get(0).park(carNumber);
    }

    public Car pick(Ticket ticket) {
        return null;
    }
}
