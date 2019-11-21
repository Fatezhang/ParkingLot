package com.tw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * unit test for Parking boy
 */
public class GradParkingBoyTest {

    @Test
    public void givenAParkingBoyOneCarportParkingLotOneCarWhenParkingThenGetATicket() {
        int id = 1;
        ParkingLot parkingLot = new ParkingLot(1, id);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        IParkingBoy gradParkingBoy = new GradParkingBoy(parkingLots);
        Car car = new Car("陕 A88888");
        Ticket ticket = gradParkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(ticket.getCarNumber(), car.getCarNumber());
        assertEquals(ticket.getParkingLotId(), id);
    }

    @Test
    public void givenAParkingBoyParkingLotWithACarAndATicketWhenPickCarThenGetThisCar() {
        int id = 1;
        String carNumber = "陕 A88888";
        ParkingLot parkingLot = new ParkingLot(1, id);
        Car car = new Car(carNumber);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        IParkingBoy gradParkingBoy = new GradParkingBoy(parkingLots);
        gradParkingBoy.park(car);
        Ticket ticket = new Ticket(carNumber, parkingLot.getId());
        Car newCar = gradParkingBoy.pick(ticket);
        assertEquals(ticket.getCarNumber(), newCar.getCarNumber());
    }

    @Test
    public void givenAParkingBoyTwoEmptyParkingLotsWithTwoCarportsWhenParkingTwoCarsThenGetTicketsBindsParkingLots() {
        int parkingLotAId = 1;
        int parkingLotBId = 2;
        String carANumber = "陕 A88888";
        String carBNumber = "陕 A66666";
        Car carA = new Car(carANumber);
        Car carB = new Car(carBNumber);
        ParkingLot parkingLotA = new ParkingLot(2, parkingLotAId);
        ParkingLot parkingLotB = new ParkingLot(2, parkingLotBId);
        List<ParkingLot> lotList = new ArrayList<>();
        lotList.add(parkingLotA);
        lotList.add(parkingLotB);
        IParkingBoy gradParkingBoy = new GradParkingBoy(lotList);

        Ticket ticketA = gradParkingBoy.park(carA);
        Ticket ticketB = gradParkingBoy.park(carB);

        assertEquals(ticketA.getCarNumber(), carANumber);
        assertEquals(ticketB.getCarNumber(), carBNumber);
        assertEquals(ticketA.getParkingLotId(), parkingLotAId);
        assertEquals(ticketB.getParkingLotId(), parkingLotAId);
    }

    @Test
    public void given1ParkingBoy2ParkingLotsWith1CarportAnd2CarWhenParkAndPickThenGetTicketBindLotA(){
        int parkingLotAId = 1;
        int parkingLotBId = 2;
        String carANumber = "陕 A88888";
        String carBNumber = "陕 A66666";
        Car carA = new Car(carANumber);
        Car carB = new Car(carBNumber);
        ParkingLot parkingLotA = new ParkingLot(1, parkingLotAId);
        ParkingLot parkingLotB = new ParkingLot(2, parkingLotBId);
        List<ParkingLot> lotList = new ArrayList<>();
        lotList.add(parkingLotA);
        lotList.add(parkingLotB);
        IParkingBoy gradParkingBoy = new GradParkingBoy(lotList);
        Ticket ticketA = gradParkingBoy.park(carA);
        Ticket ticketB = gradParkingBoy.park(carB);
        gradParkingBoy.pick(ticketA);

        Ticket ticketNewA = gradParkingBoy.park(carA);
        assertEquals(ticketNewA.getCarNumber(), carA.getCarNumber());
        assertEquals(ticketNewA.getParkingLotId(), parkingLotAId);

    }

    @Test
    public void given1ParkingBoy2ParkingLots3CarsWhenParkAllCarsThenGetTicketABindLotATicketBBindLotATicketCBindLotB(){
        int parkingLotAId = 1;
        int parkingLotBId = 2;
        String carANumber = "陕 A88888";
        String carBNumber = "陕 A66666";
        String carCNumber = "陕 A11111";
        Car carA = new Car(carANumber);
        Car carB = new Car(carBNumber);
        Car carC = new Car(carCNumber);
        ParkingLot parkingLotA = new ParkingLot(2, parkingLotAId);
        ParkingLot parkingLotB = new ParkingLot(1, parkingLotBId);
        List<ParkingLot> lotList = new ArrayList<>();
        lotList.add(parkingLotA);
        lotList.add(parkingLotB);
        IParkingBoy gradParkingBoy = new GradParkingBoy(lotList);

        Ticket ticketA = gradParkingBoy.park(carA);
        Ticket ticketB = gradParkingBoy.park(carB);
        Ticket ticketC = gradParkingBoy.park(carC);
        assertEquals(ticketA.getParkingLotId(), parkingLotAId);
        assertEquals(ticketB.getParkingLotId(), parkingLotAId);
        assertEquals(ticketC.getParkingLotId(), parkingLotBId);
    }


    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test(expected = RuntimeException.class)
    public void given1ParkingBoy1FullParkingLot1CarWhenParkingThenAlertError(){
        int parkingLotAId = 1;
        int parkingLotBId = 2;
        String carANumber = "陕 A88888";
        String carBNumber = "陕 A66666";
        String carCNumber = "陕 A11111";
        Car carA = new Car(carANumber);
        Car carB = new Car(carBNumber);
        Car carC = new Car(carCNumber);
        ParkingLot parkingLotA = new ParkingLot(1, parkingLotAId);
        ParkingLot parkingLotB = new ParkingLot(1, parkingLotBId);
        List<ParkingLot> lotList = new ArrayList<>();
        lotList.add(parkingLotA);
        lotList.add(parkingLotB);
        IParkingBoy gradParkingBoy = new GradParkingBoy(lotList);

        gradParkingBoy.park(carA);
        gradParkingBoy.park(carB);
        gradParkingBoy.park(carC);

        expectedException.expectMessage("No carports to park");

    }

    @Test(expected = RuntimeException.class)
    public void given1ParkingBoy1ParkingLot1CarWhenPickCarThenAlertError(){
        int parkingLotId = 1;
        String carNumber = "陕 A129234";
        ParkingLot parkingLot = new ParkingLot(1, parkingLotId);
        Car car = new Car(carNumber);
        List<ParkingLot> lotList = new ArrayList<>();
        lotList.add(parkingLot);
        IParkingBoy gradParkingBoy = new GradParkingBoy(lotList);
        Ticket ticket = gradParkingBoy.park(car);

        gradParkingBoy.pick(ticket);
        gradParkingBoy.pick(ticket);

        expectedException.expectMessage("Invalid ticket");



    }


}
