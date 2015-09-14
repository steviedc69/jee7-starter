package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.Remote;
import javax.ejb.Remove;

/**
 * Created by SDOAX36 on 14/09/2015.
 */
@Remote
public interface PassengerRemoteStatefulBean {

    public void createPassenger(String firstName, String lastName, String ssn, String birt);
    public void addAddress(Adress adress);
    public void addTicket(Ticket ticket);
    public Passenger getPassenger();
    @Remove
    public void checkout();

}
