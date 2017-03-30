package com.process.PersonManager.service.contentService;

import com.process.PersonManager.model.contentModel.Bank;

import java.util.List;

/**
 * Created by Кирилл on 14.02.2017.
 */
public interface BankService{
    List<Bank> findAll();
    Bank getBankById(int id);
    void addBank(Bank bank);
    void updateBank(Bank bank);
    void deleteBank(int id);

}
