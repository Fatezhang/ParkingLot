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
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void givenNoSaturationParkingWhenParkThenGetTicket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("123456");
        Ticket ticket = parkingLot.park(car);
        assertEquals(car.getCarNumber(), ticket.getCarNumber());
    }

    @Test(expected = RuntimeException.class)
    public void givenSaturationParkingWhenParkThenAlertError() {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new Car("1234"));
        parkingLot.park(new Car("12345"));
        parkingLot.park(new Car("123456"));
        expectedException.expectMessage("No Parking Lot");
    }

    @Test
    public void givenValidTicketWhenGetCarThenSuccessful() {
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car("12345"));
        Car car = parkingLot.getCar(new Ticket("12345"));
        assertEquals("12345", car.getCarNumber());
    }

    @Test(expected = RuntimeException.class)
    public void givenInvalidTicketWhenGetCarThenAlertError() {
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.getCar(new Ticket("11111"));
        expectedException.expectMessage("Invalid ticket");
        parkingLot.park(new Car("12345"));
        parkingLot.getCar(new Ticket("11111"));
        expectedException.expectMessage("Invalid ticket");
        parkingLot.getCar(new Ticket("12345"));
        parkingLot.getCar(new Ticket("12345"));
        expectedException.expectMessage("Invalid ticket");
    }

}
