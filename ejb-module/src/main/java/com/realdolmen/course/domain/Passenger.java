package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by SDOAX36 on 9/09/2015.
 */
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private String ssn;
    @Basic(optional = false)
    private String firstName;
    @Basic(optional = false)
    private String lastName;
    private Integer frequentFlyerMiles;

    public Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Long getId() {
        return id;
    }


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
}
