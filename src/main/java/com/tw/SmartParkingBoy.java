package com.tw;

import lombok.Getter;

import java.util.List;

@Getter
public class SmartParkingBoy extends AbstractParkingBoy {

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        initStrategy(new SmartStrategy(parkingLots));
    }
}
