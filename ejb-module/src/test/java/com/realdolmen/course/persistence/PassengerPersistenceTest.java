package com.realdolmen.course.persistence;


import com.realdolmen.course.domain.Passenger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

/**
 * Created by SDOAX36 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger p = new Passenger("02123321","john","Doe",15);
        entityManager().persist(p);
        assertNotNull(p.getId());
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutSsn() throws Exception {
        Passenger p = new Passenger(null, "John","Smith",15);
        entityManager().persist(p);
    }
    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutFirstName() throws Exception{
        Passenger p = new Passenger("122313213",null,"Smithers",11);
        entityManager().persist(p);
    }
    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutLastName() throws Exception{
        Passenger p = new Passenger("122313213","jan",null,11);
        entityManager().persist(p);
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {

        assertEquals("02123321",entityManager().find(Passenger.class,1L).getSsn());
    }
}
