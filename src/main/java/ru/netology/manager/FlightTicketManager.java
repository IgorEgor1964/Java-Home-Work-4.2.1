package ru.netology.manager;

import ru.netology.domain.FlightTicket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class FlightTicketManager {

    private Repository repository;

    public FlightTicketManager(Repository repository) {
        this.repository = repository;
    }

    public FlightTicketManager() {

    }

    public FlightTicket[] searchBy(String from, String to) {
        FlightTicket[] result = new FlightTicket[0];
        for (FlightTicket flyTicket : repository.findAll()) {
            if (flyTicket.matches(from, to)) {
                FlightTicket[] tmp = new FlightTicket[result.length + 1];
                tmp[tmp.length - 1] = flyTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
