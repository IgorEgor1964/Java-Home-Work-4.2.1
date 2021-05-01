package ru.netology.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class FlightTicket implements Comparable<FlightTicket> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int flightTime;

    @Override
    public int compareTo(FlightTicket o) {
        return price - o.price;

    }

    public boolean matches(String from, String to) {
        return departure.equalsIgnoreCase(from) && arrival.equalsIgnoreCase(to);
    }
}