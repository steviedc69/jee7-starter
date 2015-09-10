package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.domain.Ticket;
import org.junit.Test;

import javax.persistence.PersistenceException;

/**
 * Created by SDOAX36 on 10/09/2015.
 */
public class TicketTest extends DataSetPersistenceTest {

    @Test
    public void ticketCanBePersisted() throws Exception{
        Ticket ticket = new Ticket(121.21D, Status.PENDING);
        entityManager().persist(ticket);
        entityManager().flush();
        assertNotNull(ticket.getId());
    }

    @Test(expected =  PersistenceException.class)
    public void ticketCanNotBePersistedWithoutPrice() throws Exception{
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.PENDING);
        entityManager().persist(ticket);
        entityManager().flush();
    }
    @Test(expected = PersistenceException.class)
    public void ticketCanNotBePersistedWithoutStatus() throws Exception{
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.PENDING);
        entityManager().persist(ticket);
        entityManager().flush();
    }

    @Test
    public void ticketCanBePersistedWithPassenger() throws Exception{
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.PENDING);
        ticket.setPrice(55.21D);
        Passenger p = entityManager().find(Passenger.class, 1000L);
        p.buyTicket(ticket);
        entityManager().persist(p);
        entityManager().flush();

    }

}
