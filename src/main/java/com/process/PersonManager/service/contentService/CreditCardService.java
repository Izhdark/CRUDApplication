package com.process.PersonManager.service.contentService;

import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.contentModel.Person;
import com.process.PersonManager.model.contentModel.Purchase;

import java.util.List;

/**
 * Created by Кирилл on 14.02.2017.
 */
public interface CreditCardService {
    List<CreditCard> findAll();
    CreditCard findCreditCardById(int id);
    void addCreditCard(CreditCard creditCard);
    void updateCreditCard(CreditCard creditCard);
    void deleteCreditCard(int id);
    Person findPersonByNumberOfCreditCard(String number);
    List<Purchase> findPurchasesByIdCard(String number);
}
