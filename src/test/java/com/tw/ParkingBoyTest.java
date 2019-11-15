package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * unit test for Parking boy
 */
public class ParkingBoyTest {

    @Test
    void givenAParkingBoyOneCarportParkingLotOneCarWhenParkingThenGetATicket(){
        ParkingBoy parkingBoy = new ParkingBoy();
        int id = 1;
        ParkingLot parkingLot = new ParkingLot(1, id);
        Car car = new Car("陕 A88888");
        Ticket ticket = parkingBoy.park(car);
        assertEquals(ticket.getCarNumber(), car.getCarNumber());
        assertEquals(ticket.getParkingLotId(), id);
    }



}
