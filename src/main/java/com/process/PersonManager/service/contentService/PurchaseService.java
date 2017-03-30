package com.process.PersonManager.service.contentService;

import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.contentModel.Purchase;

import java.util.List;

/**
 * Created by Кирилл on 15.02.2017.
 */
public interface PurchaseService {
    List<Purchase> findAll();
    Purchase findPurchaseById(int id);
    void addPurchase(Purchase purchase);
    void updatePurchase(Purchase purchase);
    void deletePurchase(int id);
    CreditCard findCreditCardByIdOfPurchase(int id);
}
