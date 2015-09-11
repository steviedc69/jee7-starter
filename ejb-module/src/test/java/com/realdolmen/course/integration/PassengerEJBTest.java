package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.persistence.PassengerBean;
import com.realdolmen.course.persistence.PassengerRemoteBean;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;

/**
 * Created by SDOAX36 on 11/09/2015.
 */
public class PassengerEJBTest extends RemoteIntegrationTest {

    private static PassengerRemoteBean passengerEJB;

    @Before
    public void init() throws Exception{

        passengerEJB = lookup("ear-module-1.1/ejb-module-1.1/PassengerBean!com.realdolmen.course.persistence.PassengerRemoteBean");

    }

    @Test
    public void findPassengersTestSucces() throws Exception{
        //Passenger p = new Passenger("122313213","jan","De Boel",11,"15/02/1990", PassengerType.ECONOMY,new Adress("Sesamstraat", "", "Sprookjesbos", "99955", "Holland"));
        List<Passenger> passengers = passengerEJB.findPassengers();
        assertTrue(passengers.size()>0);
    }

    @Test
    public void findPassengerByIdSucces() throws Exception{
        Passenger passenger = passengerEJB.findPassenger(1000L);
        assertNotNull(passenger);
    }

    @Test(expected = NullPointerException.class)
    public void findPassengerByIdFailes() throws Exception{
        Passenger passenger = passengerEJB.findPassenger(10L);
        assertNull(passenger.getFirstName());
    }

    @Test
    public void createPassengerSucces() throws Exception{
        Passenger p = new Passenger("122313213","jan","De Boel",11,"15/02/1990", PassengerType.ECONOMY,new Adress("Sesamstraat", "", "Sprookjesbos", "99955", "Holland"));
        Passenger b = passengerEJB.createPassenger(p);
        assertNotNull(b.getId());
    }

    @Test
    public void deletePassengerSucces()throws Exception{

    }
}

