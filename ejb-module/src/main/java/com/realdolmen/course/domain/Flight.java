package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by SDOAX36 on 10/09/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Flight implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;
    private Date departureTime;
    private Date arrivalTime;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Passenger> passengers;

    public Flight(String number, Date departureTime, Date arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
/*
    public Collection<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Collection<Passenger> passengers) {
        this.passengers = passengers;
    }
    */
}
