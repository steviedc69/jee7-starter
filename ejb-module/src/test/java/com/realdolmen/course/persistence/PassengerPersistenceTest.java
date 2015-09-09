package com.realdolmen.course.persistence;


import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerId;
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
        Passenger p = new Passenger(new PassengerId("1112313312","Smith"),"Joht",15,"profile.jpg");
        entityManager().persist(p);
        assertNotNull(p.getId());
    }


    @Test(expected = Exception.class)
    public void passengerCanNotBePersistedWithoutFirstName() throws Exception{
        Passenger p = new Passenger(new PassengerId("1112313312","Smith"),null,15,"profile.jpg");
        entityManager().persist(p);
        entityManager().flush();
    }


    @Test
    public void passengerCanBeRetrievedById() throws Exception {

       assertEquals("john",entityManager().find(Passenger.class,new PassengerId("12552466","Doe")).getFirstName());

    }

}
