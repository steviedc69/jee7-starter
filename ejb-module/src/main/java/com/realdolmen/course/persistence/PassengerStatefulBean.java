package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by SDOAX36 on 14/09/2015.
 */
@Stateful
@StatefulTimeout(value = 20, unit = TimeUnit.MINUTES)
public class PassengerStatefulBean implements PassengerRemoteStatefulBean{

    //private List<Passenger> passList = new ArrayList<>();

    private Passenger passenger;

    @Override
    public void createPassenger(String firstName, String lastName, String ssn, String birt)
    {
        passenger = new Passenger(ssn,firstName,lastName,0,birt);
    }
    @Override
    public Passenger getPassenger()
    {
        return this.passenger;
    }

    @Override
    public void addAddress(Adress adress)
    {
        passenger.setAdress(adress);
    }
    @Override
    public void addTicket(Ticket ticket)
    {
        passenger.buyTicket(ticket);
    }

    @Override
    public void checkout()
    {
        //PassengerBean bean =
    }
}
