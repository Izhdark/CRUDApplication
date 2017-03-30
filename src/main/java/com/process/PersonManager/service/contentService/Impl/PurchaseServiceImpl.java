package com.process.PersonManager.service.contentService.Impl;

import com.process.PersonManager.dao.contentDao.PurchaseDao;
import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.contentModel.Purchase;
import com.process.PersonManager.service.contentService.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Кирилл on 15.02.2017.
 */
@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public List<Purchase> findAll() {
        return purchaseDao.findAll();
    }

    @Override
    public Purchase findPurchaseById(int id) {
        return purchaseDao.findOne(id);
    }

    @Override
    public void addPurchase(Purchase purchase) {
        purchaseDao.save(purchase);
    }

    @Override
    public void updatePurchase(Purchase purchase) {

    }

    @Override
    public void deletePurchase(int id) {
        purchaseDao.delete(id);
    }

    @Override
    public CreditCard findCreditCardByIdOfPurchase(int id) {
        return purchaseDao.findOne(id).getPrimaryCreditCard();
    }
}
