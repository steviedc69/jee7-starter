package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.CreditCard;

import javax.ejb.Remote;
import java.util.concurrent.Future;

/**
 * Created by SDOAX36 on 14/09/2015.
 */
@Remote
public interface RemotePaymentEJB {

    public Future<String> addPayByCreditCard(CreditCard creditCard);
}
