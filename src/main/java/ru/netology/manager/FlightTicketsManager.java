package ru.netology.manager;

import ru.netology.domain.FlightTickets;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class FlightTicketsManager {

    private Repository repository;

    public FlightTicketsManager(Repository repository) {
        this.repository = repository;
    }

    public FlightTicketsManager() {

    }

    public FlightTickets[] searchBy(String from, String to) {
        FlightTickets[] result = new FlightTickets[0];
        for (FlightTickets flyTickets : repository.findAll()) {
            if (flyTickets.matches(from, to)) {
                FlightTickets[] tmp = new FlightTickets[result.length + 1];
                tmp[tmp.length - 1] = flyTickets;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}