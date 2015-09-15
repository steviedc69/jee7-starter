package com.realdolmen.course.integration;

import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.CreditCardType;
import com.realdolmen.course.persistence.PaymentEJB;
import com.realdolmen.course.persistence.RemotePaymentEJB;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SDOAX36 on 14/09/2015.
 */
public class PaymentEJBTest extends RemoteIntegrationTest {

    private static RemotePaymentEJB paymentEJB;

    @Before
    public void init() throws Exception{

        paymentEJB = lookup("ear-module-1.1/ejb-module-1.1/PaymentEJB!com.realdolmen.course.persistence.RemotePaymentEJB");

    }

    @Test
    public void addPayByCreditCardTestValid() throws Exception{

        CreditCard creditCard = new CreditCard("smqldkfj","12/02",15, CreditCardType.AMEX);

        assertEquals("smqldkfj",paymentEJB.addPayByCreditCard(creditCard).get());
    }
}
