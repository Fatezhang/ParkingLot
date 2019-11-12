package com.tw;


public class ParkingLot {

    private boolean saturation;

    public ParkingLot(boolean saturation) {
        this.saturation = saturation;
    }


    public Ticket park(Car car) throws RuntimeException {

        if (saturation) {
            throw new RuntimeException("No Parking Lot");
        }

        return new Ticket(car.getCarNum());
    }
}
