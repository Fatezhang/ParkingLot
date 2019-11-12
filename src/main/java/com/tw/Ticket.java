package com.tw;

public class Ticket {

    private int carNumber;

    public Ticket(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNum() {
        return carNumber;
    }

    @Override
    public int hashCode() {
        return carNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ticket) {
            Ticket ticket = (Ticket) obj;
            return ticket.getCarNum() == this.getCarNum();
        }
        return false;
    }
}
