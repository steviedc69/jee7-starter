package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.domain.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by SDOAX36 on 11/09/2015.
 */
public class PassengerRepositoryTest extends DataSetPersistenceTest {

    public PassengerRepository repo;

    @Before
    public void initializeRepository() throws Exception{

        repo = new PassengerRepository();
        repo.em = entityManager();
    }

    @Test
    public void findAllTestReturnsList() throws Exception{

        List<Passenger> all = repo.findAll();
        assertNotNull(all);
        assertTrue(all.size()>0);
    }

    @Test
    public void findTotalFrequentFlyerMiles() throws Exception{

        Integer sumFrequent = repo.findTotalFrequentFlyerMiles();
        System.out.println("sum : " + sumFrequent);
        assertTrue(sumFrequent > 0);
    }

    @Test
    public void findTotalFrequentFlyerMilesAddedNewPassenger() throws Exception{
        int current = repo.findTotalFrequentFlyerMiles();
        System.out.println("current sum : "+current);
        Passenger p = new Passenger("02123321", "john", "Doe", 15, "15/02/1990", PassengerType.ECONOMY, new Adress("Sesamstraat", "", "Sprookjesbos", "99955", "Holland"));
        entityManager().persist(p);
        entityManager().flush();
        int afterPersist = repo.findTotalFrequentFlyerMiles();
        System.out.println("after sum : "+afterPersist);
        assertEquals(current + 15, afterPersist);
    }

    @Test
    public void findTicketsFromPassengerWithId() throws Exception
    {
        List<Ticket> tickets = repo.findTicketsFromPassengerId(1000L);
        assertNotNull(tickets);
        assertTrue(tickets.size() > 0);
    }

    @Test
    public void deletePassengersPasses() throws Exception
    {
        repo.deleteAll();
        List<Passenger> p = repo.findAll();
        assertEquals(0,p.size());

    }
}
