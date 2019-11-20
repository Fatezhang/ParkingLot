package com.tw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    public void givenASmartParkingBoyWithOneCarportParkingLotOneCarWhenParkingThenGetATicket() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.park(new Car("陕 A88888"));
        assertNotNull(ticket);
        assertEquals("陕 A88888", ticket.getCarNumber());
        assertEquals(1, ticket.getParkingLotId());
    }

    @Test
    public void givenASmartParkingBoyWithAParkingLotOneCarWhenParkingATicketThenGetACar() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Ticket ticket = parkingLot.park(new Car("陕 A88888"));
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        assertEquals("陕 A88888", parkingBoy.pick(ticket).getCarNumber());
    }

    @Test
    public void givenASmartParkingBoyWithThreeCarportParkingLotOneCarWhenParkingThenGetATicket() {
        ParkingLot parkingLot1 = new ParkingLot(3, 1);
        parkingLot1.park(new Car("111"));
        parkingLot1.park(new Car("222"));
        ParkingLot parkingLot2 = new ParkingLot(3, 2);
        parkingLot2.park(new Car("333"));
        ParkingLot parkingLot3 = new ParkingLot(3, 3);
        parkingLot3.park(new Car("444"));
        parkingLot3.park(new Car("555"));
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.park(new Car("陕 A88888"));
        assertNotNull(ticket);
        assertEquals("陕 A88888", ticket.getCarNumber());
        assertEquals(2, ticket.getParkingLotId());
    }

    @Test
    public void givenASmartParkingBoyWithThreeCarportParkingLotTwoCarWhenParkingThenGetATicket() {
        ParkingLot parkingLot1 = new ParkingLot(3, 1);
        parkingLot1.park(new Car("111"));
        parkingLot1.park(new Car("222"));
        ParkingLot parkingLot2 = new ParkingLot(3, 2);
        ParkingLot parkingLot3 = new ParkingLot(3, 3);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        Ticket ticket1 = parkingBoy.park(new Car("陕 A88888"));
        Ticket ticket2 = parkingBoy.park(new Car("陕 A99999"));
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertEquals("陕 A88888", ticket1.getCarNumber());
        assertEquals(2, ticket1.getParkingLotId());
        assertEquals("陕 A99999", ticket2.getCarNumber());
        assertEquals(3, ticket2.getParkingLotId());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = RuntimeException.class)
    public void givenASmartParkingBoyWithThreeCarportParkingLotAllFullOneCarWhenParkingThenAlertError() {
        ParkingLot parkingLot1 = new ParkingLot(1, 1);
        parkingLot1.park(new Car("111"));
        ParkingLot parkingLot2 = new ParkingLot(1, 2);
        parkingLot2.park(new Car("222"));
        ParkingLot parkingLot3 = new ParkingLot(1, 3);
        parkingLot3.park(new Car("333"));
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        parkingBoy.park(new Car("陕 A88888"));

        expectedException.expectMessage("No Parking Lot");

    }

}
