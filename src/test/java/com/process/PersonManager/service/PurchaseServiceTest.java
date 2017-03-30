package com.process.PersonManager.service;

import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.service.contentService.PurchaseService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * Created by Кирилл on 15.02.2017.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest
public class PurchaseServiceTest {
    @Autowired
    private PurchaseService purchaseService;

    private static final Logger logger = Logger.getLogger(PersonServiceTest.class);

    @Test
    public void findCreditCardByIdOfPurchase(){
        logger.info("CREDITCARD");
        CreditCard creditCard = purchaseService.findCreditCardByIdOfPurchase(2);
        logger.info("Info about person:"+creditCard);
    }
}
