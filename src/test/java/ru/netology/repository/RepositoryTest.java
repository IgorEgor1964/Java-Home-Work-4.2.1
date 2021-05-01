package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightTicket;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository = new Repository();
    FlightTicket dmeKhv = new FlightTicket(1, 1000, "VVO", "KHV", 1000);
    FlightTicket svoSip = new FlightTicket(2, 2000, "VVO", "IKT", 1100);
    FlightTicket dpsDme = new FlightTicket(3, 3000, "VVO", "ICN", 1200);
    FlightTicket dmeSip = new FlightTicket(4, 4000, "VVO", "HKG", 1600);
    FlightTicket khvSin = new FlightTicket(5, 5000, "HKG", "BKK", 1800);


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
        FlightTicket[] actual = repository.findAll();
        FlightTicket[] expected = new FlightTicket[]{dmeKhv, svoSip, dpsDme, dmeSip, khvSin};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        FlightTicket[] actual = repository.findAll();
        FlightTicket[] expected = new FlightTicket[]{dmeKhv, svoSip, dmeSip, khvSin};
        assertArrayEquals(expected, actual);
    }
}

