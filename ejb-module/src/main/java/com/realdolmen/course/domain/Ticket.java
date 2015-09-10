package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by SDOAX36 on 10/09/2015.
 */
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    private Double price;
    @ManyToOne
    //@JoinColumn(name = "pas_id")
    private Passenger passenger;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private Status status;

    public Ticket(Double price, Status status) {
        this.price = price;
        this.status = status;
    }

    public Ticket() {

    }
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ManyToOne(optional = false)
    private Passenger passengers;

    public Passenger getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passengers) {
        this.passengers = passengers;
    }
}
