package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.persistence.PassengerRemoteBean;
import com.realdolmen.course.persistence.PassengerRemoteStatefulBean;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SDOAX36 on 14/09/2015.
 */
public class StatefulPassengerBeanTest extends RemoteIntegrationTest {

    private static PassengerRemoteStatefulBean passengerEJB;

    @Before
    public void init() throws Exception{

        passengerEJB = lookup("ear-module-1.1/ejb-module-1.1/PassengerStatefulBean!com.realdolmen.course.persistence.PassengerRemoteStatefulBean");

    }

    @Test
    public void createPassengerTestValid()throws Exception
    {
        passengerEJB.createPassenger("Steven ","De Cock","msdlkqfj","08-01-1987");
        assertNotNull(passengerEJB.getPassenger());
    }
    @Test
    public void addAdressToPassengerTestValid()throws Exception{

        passengerEJB.createPassenger("Steven","De Cock","msdlekle","08-01-1987");
        passengerEJB.addAddress(new Adress("qsdmlkfj", "mqsdlfkj", "qsmldfkj", "mlsdkfj", "3131"));
        assertNotNull(passengerEJB.getPassenger().getAdress());
    }

    @Test
    public void addTicketToPassengerTestValid()throws Exception{
        passengerEJB.createPassenger("Steven", "De Cock", "msdlekle", "08-01-1987");
        //passengerEJB.addAddress(new Adress("qsdmlkfj", "mqsdlfkj", "qsmldfkj", "mlsdkfj", "3131"));
        Ticket ticket = new Ticket(12.2, Status.PENDING);
        passengerEJB.addTicket(ticket);
        assertNotNull(ticket.getPassenger().getSsn(),passengerEJB.getPassenger().getSsn());
    }

}
