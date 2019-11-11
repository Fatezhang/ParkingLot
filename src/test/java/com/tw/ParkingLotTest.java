package com.tw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for ParkingLot APP.
 */
public class ParkingLotTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();


    @Test(expected = RuntimeException.class)
    public void givenSaturationParkingWhenParkThenAlertError() {

        ParkingLot parkingLot = new ParkingLot(true);

        Car car = new Car();

        parkingLot.park(car);
        ex.expectMessage("No Parking Lot");
    }

}
