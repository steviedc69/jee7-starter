package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by SDOAX36 on 9/09/2015.
 */
public class PassengerRepository implements RemotePassengerRepository{

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Passenger> findAll() {

        return em.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    //public to remove
    public List<String> findAllLastNames()
    {
        return em.createQuery("select p.lastName from Passenger p").getResultList();
    }

    public Integer findTotalFrequentFlyerMiles(){
        Long result = (long)em.createQuery("select sum(p.frequentFlyerMiles) from Passenger p").getSingleResult();
        return result.intValue();
    }

    public List<Ticket> findTicketsFromPassengerId(long id)
    {
        return em.createQuery("select p.tickets from Passenger p where p.id = "+id).getResultList();
    }

    public void deleteAll(){
        em.createQuery("delete from Passenger p").executeUpdate();

        em.flush();
    }
}
