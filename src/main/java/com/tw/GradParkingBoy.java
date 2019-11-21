package com.tw;

import java.util.List;

public class GradParkingBoy extends AbstractParkingBoy {

    private List<ParkingLot> parkingLots;

    public GradParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        initStrategy(new gradStrategy(parkingLots));
    }

    @Override
    protected List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}
