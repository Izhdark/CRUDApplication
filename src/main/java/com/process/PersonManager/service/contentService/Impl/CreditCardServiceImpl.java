package com.process.PersonManager.service.contentService.Impl;

import com.process.PersonManager.dao.contentDao.CreditCardDao;
import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.contentModel.Person;
import com.process.PersonManager.model.contentModel.Purchase;
import com.process.PersonManager.service.contentService.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Кирилл on 14.02.2017.
 */
@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    private CreditCardDao creditCardDao;

    @Override
    public List<CreditCard> findAll() {
        return creditCardDao.findAll();
    }

    @Override
    public CreditCard findCreditCardById(int id) {
        return creditCardDao.findOne(id);
    }

    @Override
    public void addCreditCard(CreditCard creditCard) {
        creditCardDao.save(creditCard);
    }

    @Override
    public void updateCreditCard(CreditCard creditCard) {

    }

    @Override
    public void deleteCreditCard(int id) {
        creditCardDao.delete(id);
    }

    @Override
    public Person findPersonByNumberOfCreditCard(String number) {
        return creditCardDao.findByNumber(number).getPrimaryPerson();
    }

    @Override
    public List<Purchase> findPurchasesByIdCard(String number) {
        return creditCardDao.findByNumber(number).getPurchaseList();
    }

}
