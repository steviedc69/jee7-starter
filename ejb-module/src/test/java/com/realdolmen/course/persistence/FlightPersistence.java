package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.DomesticFlight;
import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.InternationalFlight;
import org.junit.Test;

import java.util.Date;

/**
 * Created by SDOAX36 on 10/09/2015.
 */
public class FlightPersistence extends DataSetPersistenceTest{


    @Test
    public void domesticFlightCanBePersisted() throws Exception{

        Flight f = new DomesticFlight("12sff",new Date(),new Date(),"Jetair");
        entityManager().persist(f);
        assertNotNull(f.getId());
    }

    @Test
    public void internationalFlightCanBePersisted() throws Exception{

        Flight f = new InternationalFlight("2313ff",new Date(),new Date(),true,"String == reetveter");
        entityManager().persist(f);
        assertNotNull(f.getId());

    }

    @Test
    public void canAddPassengerToFlight() throws Exception{


    }
}
