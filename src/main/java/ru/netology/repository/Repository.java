package ru.netology.repository;

import ru.netology.domain.FlightTickets;

public class Repository {
    private FlightTickets[] flightTickets = new FlightTickets[0];

    public FlightTickets[] findAll() {
        return flightTickets;
    }

    public void save(FlightTickets flyTickets) {
        int length = flightTickets.length + 1;
        FlightTickets[] tmp = new FlightTickets[length];
        System.arraycopy(flightTickets, 0, tmp, 0, flightTickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flyTickets;
        flightTickets = tmp;
    }

    public void removeById(int id) {
        int length = flightTickets.length - 1;
        FlightTickets[] tmp = new FlightTickets[length];
        int index = 0;
        for (FlightTickets FlightTickets : flightTickets) {
            if (FlightTickets.getId() != id) {
                tmp[index] = FlightTickets;
                index++;
            }
        }
        flightTickets = tmp;
    }

}
