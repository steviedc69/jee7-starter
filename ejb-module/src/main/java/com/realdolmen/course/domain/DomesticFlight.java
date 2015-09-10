package com.realdolmen.course.domain;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SDOAX36 on 10/09/2015.
 */
@Entity
public class DomesticFlight extends Flight {

    private String airlineCompany;
  /*  @CollectionTable(name = "references")
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String>references;
*/

    protected DomesticFlight(){}

    public DomesticFlight(String number, Date departureTime, Date arrivalTime,String airlineCompany) {
        super(number, departureTime, arrivalTime);
       // references = new ArrayList<>();
        this.airlineCompany = airlineCompany;
    }
    public void addReference(String ref)
    {
        //references.add(ref);

    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }
/*
    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
    */
}
