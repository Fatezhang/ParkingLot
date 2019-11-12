package com.tw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for ParkingLot APP.
 */
public class ParkingLotTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void givenNoSaturationParkingWhenParkThenGetTicket() {
        ParkingLot parkingLot = new ParkingLot(false);
        Car car = new Car(123456);
        Ticket ticket = parkingLot.park(car);
        assertEquals(car.getCarNum(), ticket.getCarNum());
    }

    @Test(expected = RuntimeException.class)
    public void givenSaturationParkingWhenParkThenAlertError() {

        ParkingLot parkingLot = new ParkingLot(true);

        Car car = new Car(123456);

        parkingLot.park(car);
        ex.expectMessage("No Parking Lot");
    }

}
