package com.process.PersonManager.service.contentService.Impl;

import com.process.PersonManager.dao.contentDao.BankDao;
import com.process.PersonManager.model.contentModel.Bank;
import com.process.PersonManager.service.contentService.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Кирилл on 14.02.2017.
 */

@Service
@Transactional

public class BankServiceImpl implements BankService {

    @Autowired
    private BankDao bankDao;

    @Override
    public List<Bank> findAll() {
        return bankDao.findAll();
    }

    @Override
    public Bank getBankById(int id) {
        return bankDao.findOne(id);
    }

    @Override
    public void addBank(Bank bank) {
        bankDao.save(bank);
    }

    @Override
    public void updateBank(Bank bank) {

    }

    @Override
    public void deleteBank(int id) {
        bankDao.delete(id);
    }
}
