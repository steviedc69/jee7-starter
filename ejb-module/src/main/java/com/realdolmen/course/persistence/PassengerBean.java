package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by SDOAX36 on 11/09/2015.
 */
@Stateless
@LocalBean
public class PassengerBean implements PassengerRemoteBean {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Passenger> findPassengers() {
        TypedQuery<Passenger>query = em.createNamedQuery(Passenger.FIND_ALL,Passenger.class);
        return query.getResultList();
    }

    @Override
    public Passenger findPassenger(Long id) {
        return em.find(Passenger.class,id);
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        em.persist(passenger);
        em.flush();
        return passenger;
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        em.remove(passenger);
        em.flush();
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        em.merge(passenger);
        em.flush();
        return passenger;
    }
}
