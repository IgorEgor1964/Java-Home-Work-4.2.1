package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightTickets;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository = new Repository();
    FlightTickets dmeKhv = new FlightTickets(1, 1000, "VVO", "KHV", 1000);
    FlightTickets svoSip = new FlightTickets(2, 2000, "VVO", "IKT", 1100);
    FlightTickets dpsDme = new FlightTickets(3, 3000, "VVO", "ICN", 1200);
    FlightTickets dmeSip = new FlightTickets(4, 4000, "VVO", "HKG", 1600);
    FlightTickets khvSin = new FlightTickets(5, 5000, "HKG", "BKK", 1800);


    @BeforeEach
    void setUp() {
        repository.save(dmeKhv);
        repository.save(svoSip);
        repository.save(dpsDme);
        repository.save(dmeSip);
        repository.save(khvSin);
    }

    @Test
    public void shouldFindAll() {
        FlightTickets[] actual = repository.findAll();
        FlightTickets[] expected = new FlightTickets[]{dmeKhv, svoSip, dpsDme, dmeSip, khvSin};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        FlightTickets[] actual = repository.findAll();
        FlightTickets[] expected = new FlightTickets[]{dmeKhv, svoSip, dmeSip, khvSin};
        assertArrayEquals(expected, actual);
    }
}

