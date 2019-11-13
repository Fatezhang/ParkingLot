package com.tw;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ticket {

    private int carNumber;

    @Override
    public int hashCode() {
        return carNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ticket) {
            Ticket ticket = (Ticket) obj;
            return ticket.getCarNumber() == this.getCarNumber();
        }
        return false;
    }
}
