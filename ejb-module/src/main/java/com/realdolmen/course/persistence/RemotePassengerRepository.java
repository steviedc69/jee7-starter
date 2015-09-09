package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import java.util.List;

/**
 * Created by SDOAX36 on 9/09/2015.
 */
public interface RemotePassengerRepository {
    List<Passenger>findAll();
}
