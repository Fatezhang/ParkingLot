package com.tw;

import lombok.Getter;

import java.util.List;

@Getter
public class GradParkingBoy extends AbstractParkingBoy {

    private List<ParkingLot> parkingLots;

    public GradParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        initStrategy(new GradStrategy(parkingLots));
    }
}
