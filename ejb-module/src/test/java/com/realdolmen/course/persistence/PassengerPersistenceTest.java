package com.realdolmen.course.persistence;


import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
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
        Passenger p = new Passenger("02123321","john","Doe",15,"15/02/1990", PassengerType.ECONOMY);
        entityManager().persist(p);
        assertNotNull(p.getId());
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutSsn() throws Exception {
        Passenger p = new Passenger(null, "John","Smith",15,"15/02/1990", PassengerType.ECONOMY);
        entityManager().persist(p);
        entityManager().flush();
    }
    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutFirstName() throws Exception{
        Passenger p = new Passenger("122313213",null,"Smithers",11,"15/02/1990", PassengerType.ECONOMY);
        entityManager().persist(p);
        entityManager().flush();
    }
    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutLastName() throws Exception{
        Passenger p = new Passenger("122313213","jan",null,11,"15/02/1990", PassengerType.ECONOMY);
        entityManager().persist(p);
        entityManager().flush();
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {

        assertEquals("02123321", entityManager().find(Passenger.class, 1L).getSsn());

    }

    @Test
    public void passengerAgeCanBeCalculated() throws Exception{
        Passenger p = new Passenger("122313213","jan","De Boel",11,"15/02/1990", PassengerType.ECONOMY);
        assertEquals(25,p.getAge());
    }
}
