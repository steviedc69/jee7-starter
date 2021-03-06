package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by SDOAX36 on 10/09/2015.
 */
@Embeddable
public class Adress implements Serializable{

    private String street1;
    private String street2;
    private String city;
    private String zipCode;
    private String country;

    public Adress(String street1, String street2, String city, String zipCode, String oountry) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.zipCode = zipCode;
        this.country = oountry;
    }

    public Adress() {
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String oountry) {
        this.country = oountry;
    }
}
