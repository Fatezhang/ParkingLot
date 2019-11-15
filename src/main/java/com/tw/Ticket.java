package com.tw;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ticket {

    private int lotId;

    private String carNumber;

    public Ticket(String carNumber, int lotId) {
        this.lotId = lotId;
        this.carNumber = carNumber;
    }

    @Override
    public int hashCode() {
        return carNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ticket) {
            Ticket ticket = (Ticket) obj;
            return ticket.getCarNumber().equals(this.getCarNumber());
        }
        return false;
    }

    public int getParkingLotId() {
        return lotId;
    }
}
