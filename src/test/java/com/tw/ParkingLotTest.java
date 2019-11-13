package com.tw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for ParkingLot APP.
 */
public class ParkingLotTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void givenNoSaturationParkingWhenParkThenGetTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car(123456);
        Ticket ticket = parkingLot.park(car);
        assertEquals(car.getCarNumber(), ticket.getCarNumber());
    }

    @Test(expected = RuntimeException.class)
    public void givenSaturationParkingWhenParkThenAlertError() {

        ParkingLot parkingLot = new ParkingLot(10);

        for (int i = 0; i < 11; i++) {
            parkingLot.park(new Car(i));
        }
        ex.expectMessage("No Parking Lot");
    }

    @Test
    public void givenValidTicketWhenGetCarThenSuccessful() {
        ParkingLot parkingLot = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car(i));
        }
        Car car = parkingLot.getCar(new Ticket(5));
        assertEquals(5, car.getCarNumber());
    }

    @Test(expected = RuntimeException.class)
    public void givenInvalidTicketWhenGetCarThenAlertError() {
        ParkingLot parkingLot = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car(i));
        }
        Car car = parkingLot.getCar(new Ticket(11));
        ex.expectMessage("Invalid ticket");
    }

}
