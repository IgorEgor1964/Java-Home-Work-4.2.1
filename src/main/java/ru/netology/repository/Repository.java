package ru.netology.repository;

import ru.netology.domain.FlightTicket;

public class Repository {
    private FlightTicket[] flightTicket = new FlightTicket[0];

    public FlightTicket[] findAll() {
        return flightTicket;
    }

    public void save(FlightTicket flyTicket) {
        int length = flightTicket.length + 1;
        FlightTicket[] tmp = new FlightTicket[length];
        System.arraycopy(flightTicket, 0, tmp, 0, flightTicket.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flyTicket;
        flightTicket = tmp;
    }

    public void removeById(int id) {
        int length = flightTicket.length - 1;
        FlightTicket[] tmp = new FlightTicket[length];
        int index = 0;
        for (FlightTicket FlightTicket : flightTicket) {
            if (FlightTicket.getId() != id) {
                tmp[index] = FlightTicket;
                index++;
            }
        }
        flightTicket = tmp;
    }

}