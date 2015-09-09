package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by SDOAX36 on 9/09/2015.
 */
@Embeddable
public class PassengerId implements Serializable {

    private String ssn;
    private String lastName;



    public PassengerId(String ssn, String lastName) {
        this.ssn = ssn;
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PassengerId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerId)) return false;

        PassengerId that = (PassengerId) o;

        if (getSsn() != null ? !getSsn().equals(that.getSsn()) : that.getSsn() != null) return false;
        return !(getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null);

    }

    @Override
    public int hashCode() {
        int result = getSsn() != null ? getSsn().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }
}
