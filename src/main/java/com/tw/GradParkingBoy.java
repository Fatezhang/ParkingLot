package com.tw;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GradParkingBoy extends AbstractParkingBoy{

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
