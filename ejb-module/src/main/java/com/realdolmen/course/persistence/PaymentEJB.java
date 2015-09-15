package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.CreditCard;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

/**
 * Created by SDOAX36 on 14/09/2015.
 */
@Stateless
@Asynchronous
public class PaymentEJB implements RemotePaymentEJB{

    @Resource
    SessionContext ctx;
@Override
    public Future<String>addPayByCreditCard(CreditCard creditCard){

        if(ctx.wasCancelCalled()){
            return new AsyncResult<>("Cancelled");
        }

        return new AsyncResult<>(creditCard.getNumber());

    }
}
