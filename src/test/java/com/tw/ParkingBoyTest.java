package com.tw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * unit test for Parking boy
 */
public class ParkingBoyTest {

    @Test
    void givenAParkingBoyOneCarportParkingLotOneCarWhenParkingThenGetATicket(){
        int id = 1;
        ParkingLot parkingLot = new ParkingLot(1, id);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car("陕 A88888");
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(ticket.getCarNumber(), car.getCarNumber());
        assertEquals(ticket.getParkingLotId(), id);
    }

    @Test
    void givenParkingLotWithACarAndATicketWhenPickCarThenGetThisCar(){
        int id = 1;
        String carNumber = "陕 A88888";
        ParkingLot parkingLot = new ParkingLot(1, id);
        Car car = new Car(carNumber);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);
        Ticket ticket = new Ticket(carNumber);
        Car newCar = parkingBoy.pick(ticket);
        assertEquals(ticket.getCarNumber(), newCar.getCarNumber());
    }



}
