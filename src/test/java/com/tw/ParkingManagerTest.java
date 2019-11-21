package com.tw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 泊车经理测试类
 */
public class ParkingManagerTest {

    @Test
    public void givenParkingManagerCarParkingLotWhenParkingCarThenGetTicketBindCarAndLot(){
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Car car = new Car("1234");
        List<ParkingLot> lotList = new ArrayList<>();
        lotList.add(parkingLot);
        ParkingManager parkingManager = new ParkingManager(lotList);
        Ticket ticket = parkingManager.park(car);
        assertEquals(ticket.getCarNumber(), "1234");
        assertEquals(ticket.getLotId(), 1);
    }
}
